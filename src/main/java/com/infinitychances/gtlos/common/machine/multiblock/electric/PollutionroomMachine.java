package com.infinitychances.gtlos.common.machine.multiblock.electric;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.capability.GTCapabilityHelper;
import com.gregtechceu.gtceu.api.capability.ICleanroomReceiver;
import com.gregtechceu.gtceu.api.capability.IEnergyContainer;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.SimpleGeneratorMachine;
import com.gregtechceu.gtceu.api.machine.feature.ICleanroomProvider;
import com.gregtechceu.gtceu.api.machine.feature.IDataInfoProvider;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMaintenanceMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMufflerMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.misc.EnergyContainerList;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.item.PortableScannerBehavior;
import com.gregtechceu.gtceu.common.item.PortableScannerBehavior.DisplayMode;
import com.gregtechceu.gtceu.common.machine.electric.HullMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.BedrockOreMinerMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FluidDrillMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.LargeMinerMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.generator.LargeCombustionEngineMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.generator.LargeTurbineMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DiodePartMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.CokeOvenMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitiveBlastFurnaceMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitivePumpMachine;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.infinitychances.gtlos.api.PollutionroomTypes;
import com.infinitychances.gtlos.common.data.GTLOSBlocks;
import com.infinitychances.gtlos.common.machine.trait.PollutionroomLogic;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.HoverEvent.Action;
import net.minecraft.network.chat.Style;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PollutionroomMachine extends WorkableElectricMultiblockMachine implements ICleanroomProvider, IDisplayUIMachine, IDataInfoProvider {
	protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(PollutionroomMachine.class, WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);
	public static final int CLEAN_AMOUNT_THRESHOLD = 95;
	public static final int MIN_DIRTY_AMOUNT = 0;
	public static final int MIN_RADIUS = 2;
	public static final int MIN_DEPTH = 4;
	@Persisted
	private int lDist = 0;
	@Persisted
	private int rDist = 0;
	@Persisted
	private int bDist = 0;
	@Persisted
	private int fDist = 0;
	@Persisted
	private int hDist = 0;
	private @Nullable CleanroomType cleanroomType = null;
	@Persisted
	private int dirtyAmount;
	private @Nullable
	@Getter EnergyContainerList inputEnergyContainers;
	private @Nullable
	@Getter Collection<ICleanroomReceiver> cleanroomReceivers;

	public PollutionroomMachine(IMachineBlockEntity metaTileEntityId) {
		super(metaTileEntityId);
	}

	public ManagedFieldHolder getFieldHolder() {
		return MANAGED_FIELD_HOLDER;
	}

	protected RecipeLogic createRecipeLogic(Object... args) {
		return new PollutionroomLogic(this);
	}

	public @NotNull PollutionroomLogic getRecipeLogic() {
		return (PollutionroomLogic) super.getRecipeLogic();
	}

	public void onStructureFormed() {
		super.onStructureFormed();
		initializeAbilities();
		IFilterType filterType = getMultiblockState().getMatchContext().get("FilterType");
		if (filterType != null) {
			this.cleanroomType = filterType.getCleanroomType();
		} else {
			this.cleanroomType = PollutionroomTypes.POLLUTIONROOM;
		}

		// bind cleanroom
		if (cleanroomReceivers != null) {
			this.cleanroomReceivers.forEach(receiver -> receiver.setCleanroom(null));
			this.cleanroomReceivers = null;
		}
		Set<ICleanroomReceiver> receivers = getMultiblockState().getMatchContext().getOrCreate("dirtyroomReceiver",
				Sets::newHashSet);
		this.cleanroomReceivers = ImmutableSet.copyOf(receivers);
		this.cleanroomReceivers.forEach(receiver -> receiver.setCleanroom(this));

		// max progress is based roughly on the dimensions of the structure: ((w * d) ^ .8 * h)
		// taller cleanrooms take longer than wider ones
		// minimum of 100 is a 5x5x5 cleanroom: 125-25=100 ticks
		// max sized CR is around 1142 ticks per progression

		var area = (lDist + rDist + 1) * (bDist + fDist + 1);
		var duration = Math.pow(area, 0.8) * (hDist + 1);
		this.getRecipeLogic().setDuration(Math.max(100, (int) duration));
	}

	public void onStructureInvalid() {
		super.onStructureInvalid();
		this.inputEnergyContainers = null;
		this.dirtyAmount = MIN_DIRTY_AMOUNT;
		if (cleanroomReceivers != null) {
			this.cleanroomReceivers.forEach(receiver -> receiver.setCleanroom(null));
			this.cleanroomReceivers = null;
		}

	}

	public boolean shouldAddPartToController(IMultiPart part) {
		Collection<BlockPos> cache = this.getMultiblockState().getCache();

		for (Direction side : GTUtil.DIRECTIONS) {
			if (!cache.contains(part.self().getPos().relative(side))) {
				return true;
			}
		}

		return false;
	}

	protected void initializeAbilities() {
		List<IEnergyContainer> energyContainers = new ArrayList<>();
		Long2ObjectMap<IO> ioMap = getMultiblockState().getMatchContext().getOrCreate("ioMap",
				Long2ObjectMaps::emptyMap);
		for (IMultiPart part : getParts()) {
			if (isPartIgnored(part)) continue;
			IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
			if (io == IO.NONE || io == IO.OUT) continue;
			var handlerLists = part.getRecipeHandlers();
			for (var handlerList : handlerLists) {
				if (!handlerList.isValid(io)) continue;
				handlerList.getCapability(EURecipeCapability.CAP).stream()
						.filter(IEnergyContainer.class::isInstance)
						.map(IEnergyContainer.class::cast)
						.forEach(energyContainers::add);
			}

			if (part instanceof IMaintenanceMachine maintenanceMachine) {
				getRecipeLogic().setMaintenanceMachine(maintenanceMachine);
			}
		}
		this.inputEnergyContainers = new EnergyContainerList(energyContainers);
		getRecipeLogic().setEnergyContainer(this.inputEnergyContainers);
		this.tier = Math.min(GTValues.MAX, GTUtil.getFloorTierByVoltage(getMaxVoltage()));
	}

	private static boolean isPartIgnored(IMultiPart part) {
		if (part instanceof DiodePartMachine) return true;
		if (part instanceof HullMachine) return true;

		return false;
	}

	public void updateStructureDimensions() {
		Level world = getLevel();
		if (world == null) return;
		Direction front = getFrontFacing();
		Direction back = front.getOpposite();
		Direction left = front.getCounterClockWise();
		Direction right = left.getOpposite();

		BlockPos.MutableBlockPos lPos = getPos().mutable();
		BlockPos.MutableBlockPos rPos = getPos().mutable();
		BlockPos.MutableBlockPos fPos = getPos().mutable();
		BlockPos.MutableBlockPos bPos = getPos().mutable();
		BlockPos.MutableBlockPos hPos = getPos().mutable();

		// find the distances from the controller to the blocks on one horizontal axis and the Y axis
		// repeatable aisles take care of the second horizontal axis
		int lDist = 0;
		int rDist = 0;
		int bDist = 0;
		int fDist = 0;
		int hDist = 0;

		// find the left, right, back, and front distances for the structure pattern
		// maximum size is 15x15x15 including walls, so check 7 block radius around the controller for blocks
		for (int i = 1; i < 8; i++) {
			if (lDist == 0 && isBlockEdge(world, lPos, left)) lDist = i;
			if (rDist == 0 && isBlockEdge(world, rPos, right)) rDist = i;
			if (bDist == 0 && isBlockEdge(world, bPos, back)) bDist = i;
			if (fDist == 0 && isBlockEdge(world, fPos, front)) fDist = i;
			if (lDist != 0 && rDist != 0 && bDist != 0 && fDist != 0) break;
		}

		// height is diameter instead of radius, so it needs to be done separately
		for (int i = 1; i < 15; i++) {
			if (isBlockFloor(world, hPos, Direction.DOWN)) hDist = i;
			if (hDist != 0) break;
		}

		if (Math.abs(lDist - rDist) > 1 || Math.abs(bDist - fDist) > 1) {
			this.isFormed = false;
			return;
		}

		if (lDist < MIN_RADIUS || rDist < MIN_RADIUS || bDist < MIN_RADIUS || fDist < MIN_RADIUS || hDist < MIN_DEPTH) {
			this.isFormed = false;
			return;
		}

		this.lDist = lDist;
		this.rDist = rDist;
		this.bDist = bDist;
		this.fDist = fDist;
		this.hDist = hDist;
	}

	public boolean isBlockEdge(@NotNull Level world, BlockPos.@NotNull MutableBlockPos pos, @NotNull Direction direction) {
		BlockState state = world.getBlockState(pos.move(direction));
		return state == this.getCasingState() || state == this.getGlassState();
	}

	public boolean isBlockFloor(@NotNull Level world, BlockPos.@NotNull MutableBlockPos pos, @NotNull Direction direction) {
		BlockState state = world.getBlockState(pos.move(direction));
		return state == this.getCasingState() || state == this.getGlassState() || state.is(CustomTags.CLEANROOM_FLOORS);
	}

	public @NotNull BlockPattern getPattern() {
		// return the default structure, even if there is no valid size found
		// this means auto-build will still work, and prevents terminal crashes.
		if (getLevel() != null) updateStructureDimensions();

		// these can sometimes get set to 0 when loading the game, breaking JEI
		if (lDist < MIN_RADIUS) lDist = MIN_RADIUS;
		if (rDist < MIN_RADIUS) rDist = MIN_RADIUS;
		if (bDist < MIN_RADIUS) bDist = MIN_RADIUS;
		if (fDist < MIN_RADIUS) fDist = MIN_RADIUS;
		if (hDist < MIN_DEPTH) hDist = MIN_DEPTH;

		if (this.getFrontFacing() == Direction.EAST || this.getFrontFacing() == Direction.WEST) {
			int tmp = lDist;
			lDist = rDist;
			rDist = tmp;
		}

		StringBuilder[] floorLayer = new StringBuilder[fDist + bDist + 1];
		List<StringBuilder[]> wallLayers = new ArrayList<>();
		StringBuilder[] ceilingLayer = new StringBuilder[fDist + bDist + 1];

		for (int i = 0; i < floorLayer.length; i++) {
			floorLayer[i] = new StringBuilder(lDist + rDist + 1);
			ceilingLayer[i] = new StringBuilder(lDist + rDist + 1);
		}

		for (int i = 0; i < hDist - 1; i++) {
			wallLayers.add(new StringBuilder[fDist + bDist + 1]);
			for (int j = 0; j < fDist + bDist + 1; j++) {
				var s = new StringBuilder(lDist + rDist + 1);
				wallLayers.get(i)[j] = s;
			}
		}

		for (int i = 0; i < lDist + rDist + 1; i++) {
			for (int j = 0; j < fDist + bDist + 1; j++) {
				if (i == 0 || i == lDist + rDist || j == 0 || j == fDist + bDist) { // all edges
					floorLayer[j].append('A'); // floor edge
					for (int k = 0; k < hDist - 1; k++) {
						wallLayers.get(k)[j].append('W'); // walls
					}
					ceilingLayer[j].append('D'); // ceiling edge
				} else { // not edges
					if (i == lDist && j == fDist) { // very center
						floorLayer[j].append('K');
					} else {
						floorLayer[j].append('E'); // floor valid blocks
					}
					for (int k = 0; k < hDist - 1; k++) {
						wallLayers.get(k)[j].append(' ');
					}
					if (i == lDist && j == fDist) { // very center
						ceilingLayer[j].append('C'); // controller
					} else {
						ceilingLayer[j].append('F'); // filter
					}
				}
			}
		}

		String[] f = new String[bDist + fDist + 1];
		for (int i = 0; i < floorLayer.length; i++) {
			f[i] = floorLayer[i].toString();
		}
		String[] m = new String[bDist + fDist + 1];
		for (int i = 0; i < wallLayers.get(0).length; i++) {
			m[i] = wallLayers.get(0)[i].toString();
		}
		String[] c = new String[bDist + fDist + 1];
		for (int i = 0; i < ceilingLayer.length; i++) {
			c[i] = ceilingLayer[i].toString();
		}

		var area = (lDist + rDist + 1) * (bDist + fDist + 1);
		TraceabilityPredicate wallPredicate = states(getCasingState(), getGlassState());
		TraceabilityPredicate basePredicate = abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1)
				.setMaxGlobalLimited(2)
				.or(blocks(GTMachines.MAINTENANCE_HATCH.get(), GTMachines.AUTO_MAINTENANCE_HATCH.get())
						.setMinGlobalLimited(ConfigHolder.INSTANCE.machines.enableMaintenance ? 1 : 0)
						.setMaxGlobalLimited(1))
				// limit pass through hatches to a quarter of the floor area
				.or(abilities(PartAbility.PASSTHROUGH_HATCH).setMaxGlobalLimited(area / 4));

		return FactoryBlockPattern.start(LEFT, FRONT, UP)
				.aisle(f)
				.aisle(m).setRepeatable(wallLayers.size())
				.aisle(c)
				.where('C', Predicates.controller(blocks(this.getDefinition().get())))
				.where('F', Predicates.blocks(GTLOSBlocks.POLLUTING_FILTER.get()))
				.where('D', states(getCasingState())) // ceiling edges
				.where(' ', innerPredicate())
				.where('E', wallPredicate.or(basePredicate) // inner floor
						.or(getValidFloorBlocks().setMaxGlobalLimited(4)))
				.where('K', wallPredicate // very center floor, needed for height check
						.or(getValidFloorBlocks()))
				.where('W', wallPredicate.or(basePredicate)// walls
						.or(doorPredicate().setMaxGlobalLimited(8)))
				.where('A', wallPredicate.or(basePredicate)) // floor edges
				.build();
	}

	protected @NotNull BlockState getCasingState() {
		return GTLOSBlocks.CASING_HYPERPACKED_MUD.getDefaultState();
	}

	protected @NotNull BlockState getGlassState() {
		return GTBlocks.CLEANROOM_GLASS.getDefaultState();
	}

	protected static @NotNull TraceabilityPredicate doorPredicate() {
		return Predicates.custom((blockWorldState) -> blockWorldState.getBlockState().is(CustomTags.CLEANROOM_DOORS),
				() -> new BlockInfo[]{new BlockInfo(Blocks.IRON_DOOR.defaultBlockState()),
						new BlockInfo(Blocks.IRON_DOOR.defaultBlockState().setValue(DoorBlock.HALF, DoubleBlockHalf.UPPER))});
	}

	private TraceabilityPredicate getValidFloorBlocks() {
		return Predicates.blockTag(CustomTags.CLEANROOM_FLOORS);
	}

	protected @NotNull TraceabilityPredicate innerPredicate() {
		return new TraceabilityPredicate(blockWorldState -> {
			Set<ICleanroomReceiver> receivers = blockWorldState.getMatchContext().getOrCreate("dirtyroomReceiver",
					Sets::newHashSet);
			// all non-GTMachines are allowed inside by default
			BlockEntity blockEntity = blockWorldState.getTileEntity();
			if (blockEntity instanceof IMachineBlockEntity machineBlockEntity) {
				var machine = machineBlockEntity.getMetaMachine();
				if (isMachineBanned(machine)) {
					return false;
				}
			}
			if (blockEntity != null) {
				var receiver = GTCapabilityHelper.getCleanroomReceiver(blockWorldState.getWorld(),
						blockWorldState.getPos(), null);
				if (receiver != null) {
					receivers.add(receiver);
				}
			}
			return true;
		}, null) {

			@Override
			public boolean isAny() {
				return true;
			}

			@Override
			public boolean addCache() {
				return true;
			}
		};
	}

	protected boolean isMachineBanned(MetaMachine machine) {
		// blacklisted machines: mufflers and all generators, miners/drills, primitives
		if (machine instanceof ICleanroomProvider) return true;
		if (machine instanceof IMufflerMachine) return true;
		if (machine instanceof SimpleGeneratorMachine) return true;
		if (machine instanceof LargeCombustionEngineMachine) return true;
		if (machine instanceof LargeTurbineMachine) return true;

		if (machine instanceof LargeMinerMachine) return true;
		if (machine instanceof FluidDrillMachine) return true;
		if (machine instanceof BedrockOreMinerMachine) return true;

		if (machine instanceof CokeOvenMachine) return true;
		if (machine instanceof PrimitiveBlastFurnaceMachine) return true;
		return machine instanceof PrimitivePumpMachine;
	}

	public void addDisplayText(List<Component> textList) {
		if (this.isFormed()) {
			long maxVoltage = this.getMaxVoltage();
			if (maxVoltage > 0L) {
				String voltageName = GTValues.VNF[GTUtil.getFloorTierByVoltage(maxVoltage)];
				textList.add(Component.translatable("gtceu.multiblock.max_energy_per_tick", new Object[]{maxVoltage, voltageName}));
			}

			if (this.cleanroomType != null) {
				textList.add(Component.translatable(this.cleanroomType.getTranslationKey()));
			}

			if (!this.isWorkingEnabled()) {
				textList.add(Component.translatable("gtceu.multiblock.work_paused"));
			} else if (this.isActive()) {
				textList.add(Component.translatable("gtceu.multiblock.running"));
				int currentProgress = (int) (this.recipeLogic.getProgressPercent() * (double) 100.0F);
				double maxInSec = (double) ((float) this.recipeLogic.getDuration() / 20.0F);
				double currentInSec = (double) ((float) this.recipeLogic.getProgress() / 20.0F);
				textList.add(Component.translatable("gtceu.multiblock.progress", new Object[]{String.format("%.2f", (float) currentInSec), String.format("%.2f", (float) maxInSec), currentProgress}));
			} else {
				textList.add(Component.translatable("gtceu.multiblock.idling"));
			}

			if (this.recipeLogic.isWaiting()) {
				textList.add(Component.translatable("gtceu.multiblock.waiting").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
			}

			if (this.isClean()) {
				textList.add(Component.translatable("gtlos.multiblock.pollutionroom.dirty_state"));
			} else {
				textList.add(Component.translatable("gtlos.multiblock.pollutionroom.clean_state"));
			}

			textList.add(Component.translatable("gtlos.multiblock.pollutionroom.dirty_amount", this.dirtyAmount));
			textList.add(Component.translatable("gtceu.multiblock.dimensions.0"));
			textList.add(Component.translatable("gtceu.multiblock.dimensions.1", new Object[]{this.lDist + this.rDist + 1, this.hDist + 1, this.fDist + this.bDist + 1}));
		} else {
			Component tooltip = Component.translatable("gtceu.multiblock.invalid_structure.tooltip").withStyle(ChatFormatting.GRAY);
			textList.add(Component.translatable("gtceu.multiblock.invalid_structure").withStyle(Style.EMPTY.withColor(ChatFormatting.RED).withHoverEvent(new HoverEvent(Action.SHOW_TEXT, tooltip))));
		}

	}

	public Set<CleanroomType> getTypes() {
		return this.cleanroomType == null ? Set.of() : Set.of(this.cleanroomType);
	}

	public void adjustDirtyAmount(int amount) {
		this.dirtyAmount = Mth.clamp(this.dirtyAmount + amount, 0, 100);
	}

	public boolean isClean() {
		return this.dirtyAmount >= CLEAN_AMOUNT_THRESHOLD;
	}

	public @NotNull List<Component> getDataInfo(PortableScannerBehavior.DisplayMode mode) {
		return mode != DisplayMode.SHOW_ALL && mode != DisplayMode.SHOW_MACHINE_INFO ? new ArrayList<>() : Collections.singletonList(Component.translatable(this.isClean() ? "gtceu.multiblock.cleanroom.clean_state" : "gtceu.multiblock.cleanroom.dirty_state"));
	}

	public long getMaxVoltage() {
		return this.inputEnergyContainers == null ? 1L : this.inputEnergyContainers.getInputVoltage();
	}

	public boolean isWorkingEnabled() {
		return true;
	}

	public void setWorkingEnabled(boolean ignored) {
	}

}
