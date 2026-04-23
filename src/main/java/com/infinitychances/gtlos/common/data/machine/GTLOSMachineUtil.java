package com.infinitychances.gtlos.common.data.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.infinitychances.gtlos.common.machine.multiblock.primitive.CokeOvenMachine;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.controller;
import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_COKE_BRICKS;
import static com.gregtechceu.gtceu.common.data.GTMachines.COKE_OVEN_HATCH;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.COKE_OVEN_RECIPES;
import static com.infinitychances.gtlos.GTLOS.REGISTRATE;

public class GTLOSMachineUtil {

	public static MultiblockMachineDefinition makeCoveOvenDef(int parallels) {
		return REGISTRATE.multiblock("x"+parallels+"_coke_oven", (def) -> new CokeOvenMachine(def, parallels))
				.rotationState(RotationState.ALL)
				.recipeType(COKE_OVEN_RECIPES)
				.appearanceBlock(CASING_COKE_BRICKS)
				.recipeModifier(CokeOvenMachine::recipeModifier)
				.pattern(definition -> FactoryBlockPattern.start(LEFT, UP, BACK)
						.aisle("AAA", "A@A", "AAA")
						.aisle("AAA", "A#A", "AAA").setRepeatable(1, parallels)
						.aisle("AAA", "AAA", "AAA")
						.where("@", controller(blocks(definition.get())))
						.where("A", blocks(CASING_COKE_BRICKS.get())
								.or(blocks(COKE_OVEN_HATCH.get())))
						.where("#", Predicates.air())
						.build())
				.shapeInfos(definition -> {
					List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
					var builder = MultiblockShapeInfo.builder()
							.where('C', definition, Direction.NORTH)
							.where('B', CASING_COKE_BRICKS.getDefaultState())
							.where('#', Blocks.AIR.defaultBlockState());
					for (int height = 3; height <= 18; height++) {
						List<String[]> aisles = new ArrayList<>();
						aisles.add(new String[] { "BBB", "BCB", "BBB" });
						for (int i = 1; i < height - 1; i++) {
							aisles.add(new String[] { "BBB", "B#B", "BBB" });
						}
						aisles.add(new String[] { "BBB", "BBB", "BBB" });
						var copy = builder.shallowCopy();
						for (String[] aisle : aisles) {
							copy.aisle(aisle);
						}
						shapeInfos.add(copy.build());
					}
					return shapeInfos;
				})
				.tooltipBuilder((stack, tooltip) -> {
					tooltip.add(Component.translatable("tooltip.gtlos.machine.coke_oven_description"));
					tooltip.add(Component
							.translatable("tooltip.gtlos.machine.coke_oven_parallels", parallels));
				})
				.workableCasingModel(GTCEu.id("block/casings/solid/machine_coke_bricks"),
						GTCEu.id("block/multiblock/coke_oven"))
				.register();
	}
}
