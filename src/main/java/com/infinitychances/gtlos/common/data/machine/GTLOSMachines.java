package com.infinitychances.gtlos.common.data.machine;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.GTLOSRecipeTypes;

import static com.gregtechceu.gtceu.api.GTValues.*;

public class GTLOSMachines {
	public static void init() {

	}

	public static final MachineDefinition[] PELLET_DECOMPOSITIONING = GTMachineUtils.registerSimpleMachines(GTLOS.REGISTRATE, "pellet_decompositioning",
			GTLOSRecipeTypes.PELLET_DECOMPOSITIONING,
			GTMachineUtils.hvCappedTankSizeFunction, false, 0, 1, 2);
	public static final MachineDefinition[] MERCURY_GENERATOR = GTLOSMachineUtil.registerSimpleGenerator(GTLOS.REGISTRATE, "mercury",
			GTLOSRecipeTypes.MERCURY_GENERATING,
			GTMachineUtils.defaultTankSizeFunction, 0.1f, 0, 1, 2, 3, 4);
}
