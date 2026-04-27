package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.infinitychances.gtlos.GTLOS;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

import static com.infinitychances.gtlos.GTLOS.REGISTRATE;

public class GTLOSItems {
	static {
		REGISTRATE.creativeModeTab(() -> GTLOSCreativeModeTab.MAIN);
	}

	public static ItemEntry<Item> OXYGEN_PELLET = REGISTRATE.item("oxygen_pellet", Item::new).lang("Oxygen Pellet").register();
	//public static ItemEntry<Item> SPACE_DUST = REGISTRATE.item("space_dust", Item::new).lang("Space Dust").tag(Tags.Items.DUSTS).register();

	public static void init() {
		GTLOSCircuits.init();
	}
}
