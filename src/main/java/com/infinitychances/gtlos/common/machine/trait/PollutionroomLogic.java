package com.infinitychances.gtlos.common.machine.trait;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IEnergyContainer;
import com.gregtechceu.gtceu.api.capability.IWorkable;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMaintenanceMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.capability.EnvironmentalHazardSavedData;
import com.infinitychances.gtlos.common.machine.multiblock.electric.PollutionroomMachine;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

public class PollutionroomLogic extends RecipeLogic implements IWorkable {
	protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(PollutionroomLogic.class, RecipeLogic.MANAGED_FIELD_HOLDER);
	public static final int BASE_DIRTY_AMOUNT = 2;
	private @Setter @Nullable IMaintenanceMachine maintenanceMachine;
	private @Setter @Nullable IEnergyContainer energyContainer;
	@Persisted
	private @Setter @Getter boolean isActiveAndNeedsUpdate;

	public PollutionroomLogic(PollutionroomMachine machine) {
		super(machine);
	}

	public PollutionroomMachine getMachine() {
		return (PollutionroomMachine)this.machine;
	}

	public ManagedFieldHolder getFieldHolder() {
		return MANAGED_FIELD_HOLDER;
	}

	public void serverTick() {
		if (this.duration > 0) {
			EnvironmentalHazardSavedData environmentalHazards = EnvironmentalHazardSavedData.getOrCreate((ServerLevel)this.getMachine().getLevel());
			EnvironmentalHazardSavedData.HazardZone zone = environmentalHazards.getZoneByContainedPos(this.getMachine().getPos());
			if (this.maintenanceMachine != null && this.maintenanceMachine.getNumMaintenanceProblems() >= 6 && zone == null) {
				if (this.progress > 0) {
					--this.progress;
				}

				if (this.machine.self().getOffsetTimer() % (long)this.duration == 0L) {
					this.adjustPollutionAmount(true);
				}

				this.setStatus(Status.IDLE);
				this.machine.afterWorking();
			} else {
				if (!this.consumeEnergy()) {
					if (this.progress > 0 && this.machine.regressWhenWaiting()) {
						this.progress = 1;
					}

					if (this.machine.self().getOffsetTimer() % (long)this.duration == 0L) {
						this.adjustPollutionAmount(true);
					}

					this.setWaiting(Component.translatable("gtceu.recipe_logic.insufficient_in").append(": ").append(EURecipeCapability.CAP.getName()));
					return;
				}

				this.setStatus(Status.WORKING);
				if (this.progress++ < this.getMaxProgress()) {
					if (!this.machine.onWorking()) {
						this.interruptRecipe();
					}

					return;
				}

				this.progress = 0;
				if (!this.machine.beforeWorking((GTRecipe)null)) {
					return;
				}

				if(this.machine.getCleanroom() != null) {
					this.adjustPollutionAmount(true);
				} else {
					this.adjustPollutionAmount(false);
				}
			}
		}

	}

	protected void adjustPollutionAmount(boolean declined) {
		int amountToPollute = BASE_DIRTY_AMOUNT + 3 * (this.getTierDifference() + 1);
		if (declined) {
			amountToPollute *= -1;
		}

		if (this.maintenanceMachine != null) {
			amountToPollute -= this.maintenanceMachine.getNumMaintenanceProblems();
		}

		this.getMachine().adjustDirtyAmount(amountToPollute);
	}

	protected boolean consumeEnergy() {
		PollutionroomMachine pollutionroom = this.getMachine();
		int tier = Mth.clamp(pollutionroom.getTier(), 0, 14);
		long energyToDrain = pollutionroom.isClean() ? Math.max(8L, 3L * GTValues.V[tier] / 16L) : (long)GTValues.VA[tier];
		if (this.energyContainer != null) {
			long resultEnergy = this.energyContainer.getEnergyStored() - energyToDrain;
			if (resultEnergy >= 0L && resultEnergy <= this.energyContainer.getEnergyCapacity()) {
				this.energyContainer.removeEnergy(energyToDrain);
				return true;
			}
		}

		return false;
	}

	protected int getTierDifference() {
		int minEnergyTier = 1;
		return Math.max(0, this.getMachine().getTier() - minEnergyTier);
	}

	public void setDuration(int max) {
		this.duration = max;
	}

}

