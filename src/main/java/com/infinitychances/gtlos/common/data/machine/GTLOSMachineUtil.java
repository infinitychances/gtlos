package com.infinitychances.gtlos.common.data.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.SimpleGeneratorMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.machine.multiblock.primitive.CokeOvenMachine;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
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

	public static MachineDefinition[] registerSimpleGenerator(String name, GTRecipeType recipeType, Int2IntFunction tankScalingFunction, float hazardStrengthPerOperation, int... tiers) {
		return registerSimpleGenerator(REGISTRATE, name, recipeType, tankScalingFunction, hazardStrengthPerOperation, tiers);
	}

	public static MachineDefinition[] registerSimpleGenerator(GTRegistrate registrate, String name, GTRecipeType recipeType, Int2IntFunction tankScalingFunction, float hazardStrengthPerOperation, int... tiers) {
		return GTMachineUtils.registerTieredMachines(registrate, name, (holder, tier) ->
				new SimpleGeneratorMachine(holder, tier, hazardStrengthPerOperation * (float)tier,
						tankScalingFunction), (tier, builder) ->
				builder.langValue("%s %s Generator %s".formatted(GTValues.VLVH[tier], FormattingUtil.toEnglishName(name), GTValues.VLVT[tier]))
						.editableUI(SimpleGeneratorMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
						.rotationState(RotationState.ALL)
						.recipeType(recipeType).recipeModifier(SimpleGeneratorMachine::recipeModifier, true)
						.addOutputLimit(ItemRecipeCapability.CAP, 0).addOutputLimit(FluidRecipeCapability.CAP, 0)
						.simpleGeneratorModel(GTLOS.id("block/generators/" + name))
						.tooltips(GTMachineUtils.workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64L, recipeType, tankScalingFunction.applyAsInt(tier), false)).register(), tiers);
	}
}
