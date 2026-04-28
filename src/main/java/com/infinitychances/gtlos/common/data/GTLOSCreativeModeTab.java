package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.machine.GTLOSMultiblockMachines;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static com.infinitychances.gtlos.GTLOS.REGISTRATE;

public class GTLOSCreativeModeTab {
	public static RegistryEntry<CreativeModeTab> MAIN = REGISTRATE.defaultCreativeTab("main",
					builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("main", REGISTRATE))
							.icon(() -> GTLOSItems.OXYGEN_PELLET.asStack())
							.title(REGISTRATE.addLang("itemGroup", GTLOS.id("main"), "GTLOS Items"))
							.build())
			.register();

	public static RegistryEntry<CreativeModeTab> BLOCKS = REGISTRATE.defaultCreativeTab("blocks",
					builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("blocks", REGISTRATE))
							.icon(() -> GTLOSBlocks.COIL_RUBIDIUM.asStack())
							.title(REGISTRATE.addLang("itemGroup", GTLOS.id("blocks"), "GTLOS Blocks"))
							.build())
			.register();

	public static RegistryEntry<CreativeModeTab> CIRCUITS = REGISTRATE.defaultCreativeTab("circuits",
					builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("circuits", REGISTRATE))
							.icon(() -> GTLOSCircuits.UNIVERSAL_LV_CIRCUIT.asStack())
							.title(REGISTRATE.addLang("itemGroup", GTLOS.id("circuits"), "GTLOS Circuits"))
							.build())
			.register();

	public static RegistryEntry<CreativeModeTab> MACHINES = REGISTRATE.defaultCreativeTab("machines",
					builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machines", REGISTRATE))
							.icon(GTLOSMultiblockMachines.X2_COKE_OVEN::asStack)
							.title(REGISTRATE.addLang("itemGroup", GTLOS.id("machines"), "GTLOS Machines"))
							.build())
			.register();
}
