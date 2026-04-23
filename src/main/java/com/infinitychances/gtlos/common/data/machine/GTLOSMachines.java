package com.infinitychances.gtlos.common.data.machine;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.GTLOSCreativeModeTab;
import com.infinitychances.gtlos.common.data.GTLOSRecipeTypes;

public class GTLOSMachines {
	public static void init() {

	}

	public static final MachineDefinition[] PELLET_DECOMPOSITIONER = GTMachineUtils.registerSimpleMachines(GTLOS.REGISTRATE, "pellet_decompositioner",
			GTLOSRecipeTypes.PELLET_DECOMPOSITIONING,
			GTMachineUtils.hvCappedTankSizeFunction, false, 0, 1, 2);
}
