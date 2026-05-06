package com.infinitychances.gtlos.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.infinitychances.gtlos.api.PollutionroomTypes;
import com.infinitychances.gtlos.common.data.GTLOSBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PollutionroomMachine extends AbstractCleanroomMachine {

	public PollutionroomMachine(IMachineBlockEntity metaTileEntityId) {
		super(metaTileEntityId);
	}

	@Override
	public @NotNull TraceabilityPredicate getValidFloorBlocks() {
		return Predicates.blockTag(CustomTags.CLEANROOM_FLOORS);
	}

	@Override
	public @NotNull String getMaxStateTextKey() {
		return "gtlos.multiblock.pollutionroom.dirty_state";
	}

	@Override
	public @NotNull String getContaminatedStateTextKey() {
		return "gtlos.multiblock.pollutionroom.clean_state";
	}

	@Override
	public String getStatusTextKey() {
		return "gtlos.multiblock.pollutionroom.dirty_amount";
	}

	@Override
	public CleanroomType baseType() {
		return getCleanroom() != null && getCleanroom().isClean() ? PollutionroomTypes.POLLUTIONROOM : PollutionroomTypes.POLLUTIONROOM;
	}

	@Override
	protected @NotNull BlockState getCasingState() {
		return GTLOSBlocks.CASING_HYPERPACKED_MUD.getDefaultState();
	}

	@Override
	protected @NotNull BlockState getGlassState() {
		return GTBlocks.CLEANROOM_GLASS.getDefaultState();
	}

	@Override
	protected @NotNull Block[] getFilters() {
		return new Block[]{GTLOSBlocks.POLLUTING_FILTER.get()};
	}
}
