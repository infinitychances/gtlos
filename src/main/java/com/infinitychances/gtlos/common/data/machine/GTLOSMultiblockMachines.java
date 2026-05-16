package com.infinitychances.gtlos.common.data.machine;

import appeng.api.networking.pathing.ChannelMode;
import appeng.core.AEConfig;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.GTLOSBlocks;
import com.infinitychances.gtlos.common.data.GTLOSRecipeTypes;
import com.infinitychances.gtlos.common.machine.multiblock.electric.PollutionroomMachine;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.ArrayList;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DUMMY_RECIPES;
import static com.infinitychances.gtlos.GTLOS.REGISTRATE;

public class GTLOSMultiblockMachines {
	public static void init() {
	}

	public static final MultiblockMachineDefinition X2_COKE_OVEN = GTLOSMachineUtil.makeCoveOvenDef(2);
	public static final MultiblockMachineDefinition X4_COKE_OVEN = GTLOSMachineUtil.makeCoveOvenDef(4);
	public static final MultiblockMachineDefinition X8_COKE_OVEN = GTLOSMachineUtil.makeCoveOvenDef(8);
	public static final MultiblockMachineDefinition X16_COKE_OVEN = GTLOSMachineUtil.makeCoveOvenDef(16);
	public static final MultiblockMachineDefinition POLLUTION_ROOM = REGISTRATE
			.multiblock("pollutionroom", PollutionroomMachine::new)
			.rotationState(RotationState.NONE)
			.recipeType(DUMMY_RECIPES)
			.appearanceBlock(GTLOSBlocks.CASING_HYPERPACKED_MUD)
			.tooltips(Component.translatable("gtceu.machine.cleanroom.tooltip.0"),
					Component.translatable("gtceu.machine.cleanroom.tooltip.1"),
					Component.translatable("gtceu.machine.cleanroom.tooltip.2"),
					Component.translatable("gtceu.machine.cleanroom.tooltip.3"))
			.tooltipBuilder((stack, tooltip) -> {
				if (GTUtil.isCtrlDown()) {
					tooltip.add(Component.empty());
					tooltip.add(Component.translatable("gtceu.machine.cleanroom.tooltip.4"));
					tooltip.add(Component.translatable("gtceu.machine.cleanroom.tooltip.5"));
					tooltip.add(Component.translatable("gtceu.machine.cleanroom.tooltip.6"));
					tooltip.add(Component.translatable("gtceu.machine.cleanroom.tooltip.7"));
					// tooltip.add(Component.translatable("gtceu.machine.cleanroom.tooltip.8"));
					if (GTCEu.Mods.isAE2Loaded()) {
						tooltip.add(
								Component.translatable(AEConfig.instance().getChannelMode() == ChannelMode.INFINITE ?
										"gtceu.machine.cleanroom.tooltip.ae2.no_channels" :
										"gtceu.machine.cleanroom.tooltip.ae2.channels"));
					}
					tooltip.add(Component.empty());
				} else {
					tooltip.add(Component.translatable("gtceu.machine.cleanroom.tooltip.hold_ctrl"));
				}
			})
			.pattern((definition) -> { return FactoryBlockPattern.start()
					.aisle("XXXXX", "XXXXX", "XXXXX", "XXXXX", "XXXXX")
					.aisle("XXXXX", "X   X", "X   X", "X   X", "XFFFX")
					.aisle("XXXXX", "X   X", "X   X", "X   X", "XFSFX")
					.aisle("XXXXX", "X   X", "X   X", "X   X", "XFFFX")
					.aisle("XXXXX", "XXXXX", "XXXXX", "XXXXX", "XXXXX")
					.where('X', blocks(GTLOSBlocks.CASING_HYPERPACKED_MUD.get())
							.or(blocks(GTBlocks.CLEANROOM_GLASS.get()))
							.or(abilities(PartAbility.PASSTHROUGH_HATCH).setMaxGlobalLimited(30, 3))
							.or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3, 2))
							.or(blocks(ConfigHolder.INSTANCE.machines.enableMaintenance ?
									GTMachines.MAINTENANCE_HATCH.getBlock() : GTLOSBlocks.CASING_HYPERPACKED_MUD.get()).setExactLimit(1))
							.or(blocks(Blocks.IRON_DOOR).setMaxGlobalLimited(8)))
					.where('S', controller(blocks(definition.getBlock())))
					.where(' ', any())
					.where('E', abilities(PartAbility.INPUT_ENERGY))
					.where('F', blocks(GTLOSBlocks.POLLUTING_FILTER.get()))
					.where('I', abilities(PartAbility.PASSTHROUGH_HATCH))
					.build();})
			.shapeInfos((controller) -> {
				ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
				MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
						.aisle("XXXXX", "XIHLX", "XXDXX", "XXXXX", "XXXXX")
						.aisle("XXXXX", "X   X", "G   G", "X   X", "XFFFX")
						.aisle("XXXXX", "X   X", "G   G", "X   X", "XFSFX")
						.aisle("XXXXX", "X   X", "G   G", "X   X", "XFFFX")
						.aisle("XMXEX", "XXOXX", "XXRXX", "XXXXX", "XXXXX")
						.where('X', GTLOSBlocks.CASING_HYPERPACKED_MUD)
						.where('G', GTBlocks.CLEANROOM_GLASS)
						.where('S', GTLOSMultiblockMachines.POLLUTION_ROOM.getBlock())
						.where(' ', Blocks.AIR)
						.where('E', GTMachines.ENERGY_INPUT_HATCH[GTValues.LV], Direction.SOUTH)
						.where('I', GTMachines.ITEM_PASSTHROUGH_HATCH[GTValues.LV], Direction.NORTH)
						.where('L', GTMachines.FLUID_PASSTHROUGH_HATCH[GTValues.LV], Direction.NORTH)
						.where('H', GTMachines.HULL[GTValues.HV], Direction.NORTH)
						.where('D', GTMachines.DIODE[GTValues.HV], Direction.NORTH)
						.where('O',
								Blocks.IRON_DOOR.defaultBlockState().setValue(DoorBlock.FACING, Direction.NORTH)
										.setValue(DoorBlock.HALF, DoubleBlockHalf.LOWER))
						.where('R', Blocks.IRON_DOOR.defaultBlockState().setValue(DoorBlock.FACING, Direction.NORTH)
								.setValue(DoorBlock.HALF, DoubleBlockHalf.UPPER))
						.where('F', GTLOSBlocks.POLLUTING_FILTER.get());
				if (ConfigHolder.INSTANCE.machines.enableMaintenance) {
					builder.where('M', GTMachines.MAINTENANCE_HATCH, Direction.SOUTH);
				} else {
					builder.where('M', GTLOSBlocks.CASING_HYPERPACKED_MUD);
				}
				shapeInfo.add(builder.build());
				//GTCEuAPI.CLEANROOM_FILTERS.values().forEach(block -> shapeInfo.add(builder.where('F', block.get()).build()));
				return shapeInfo;
			})
			.allowExtendedFacing(false)
			.allowFlip(false)
			.workableCasingModel(GTLOS.id("block/casings/solid/machine_casing_hyperpacked_mud"),
					GTCEu.id("block/multiblock/cleanroom"))
			.register();
	public static final MultiblockMachineDefinition CRYSTAL_GROWTH_CHAMBER = REGISTRATE
			.multiblock("crystal_growth_chamber", WorkableElectricMultiblockMachine::new)
			.rotationState(RotationState.ALL)
			.recipeType(GTLOSRecipeTypes.CRYSTAL_GROWTH)
			.appearanceBlock(GTBlocks.CASING_TITANIUM_STABLE)
			//.tooltips()
			.pattern(def -> {
				return FactoryBlockPattern.start()
						.aisle("XXX", "XXX", "XXX")
						.aisle("XXX", "XTX", "XXX")
						.aisle("XXX", "XCX", "XXX")
						.where('T', blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
						.where('C', controller(blocks(def.getBlock())))
						.where('X', blocks(GTBlocks.CASING_TITANIUM_STABLE.get())
								.or(abilities(PartAbility.INPUT_ENERGY).setMaxGlobalLimited(2))
								.or(ConfigHolder.INSTANCE.machines.enableMaintenance ?
										abilities(PartAbility.MAINTENANCE).setExactLimit(1) : blocks(GTBlocks.CASING_TITANIUM_STABLE.get()))
								.or(abilities(PartAbility.IMPORT_ITEMS).setExactLimit(1))
								.or(abilities(PartAbility.EXPORT_ITEMS).setExactLimit(1)))
						.build();
			})
			.shapeInfos(def -> {
				ArrayList<MultiblockShapeInfo> infos = new ArrayList<>();
				var i = MultiblockShapeInfo.builder()
						.aisle("XXX", "ICO", "XMX")
						.aisle("XXX", "XTX", "XXX")
						.aisle("EXE", "XXX", "XXX")
						.where('T', GTBlocks.CASING_TEMPERED_GLASS.get())
						.where('C', def.getBlock())
						.where('X', GTBlocks.CASING_TITANIUM_STABLE.get())
						.where('E', GTMachines.ENERGY_INPUT_HATCH[GTValues.HV].defaultBlockState().setValue(BlockStateProperties.FACING, Direction.SOUTH))
						.where( 'M', ConfigHolder.INSTANCE.machines.enableMaintenance ?
										GTMachines.MAINTENANCE_HATCH.getBlock() : GTBlocks.CASING_TITANIUM_STABLE.get())
						.where('I', GTMachines.ITEM_IMPORT_BUS[GTValues.HV].getBlock())
						.where('O', GTMachines.ITEM_EXPORT_BUS[GTValues.HV].getBlock()).build();
				infos.add(i);
				return infos;
			})
			.workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_stable_titanium"),
					GTLOS.id("block/multiblock/crystal_growth_chamber")).register();
}
