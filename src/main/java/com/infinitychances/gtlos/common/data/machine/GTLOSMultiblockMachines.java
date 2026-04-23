package com.infinitychances.gtlos.common.data.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.GTLOSCreativeModeTab;
import com.infinitychances.gtlos.common.machine.multiblock.primitive.CokeOvenMachine;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.COKE_OVEN_HATCH;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.COKE_OVEN_RECIPES;
import static com.infinitychances.gtlos.GTLOS.REGISTRATE;

public class GTLOSMultiblockMachines {
	public static void init() {
	}

	public static final MultiblockMachineDefinition X2_COKE_OVEN = GTLOSMachineUtil.makeCoveOvenDef(2);
	public static final MultiblockMachineDefinition X4_COKE_OVEN = GTLOSMachineUtil.makeCoveOvenDef(4);
	public static final MultiblockMachineDefinition X8_COKE_OVEN = GTLOSMachineUtil.makeCoveOvenDef(8);
	public static final MultiblockMachineDefinition X16_COKE_OVEN = GTLOSMachineUtil.makeCoveOvenDef(16);

}
