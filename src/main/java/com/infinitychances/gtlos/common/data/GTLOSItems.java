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
	public static ItemEntry<Item> BLANK_UNIVERSAL_CIRCUIT = REGISTRATE.item("blank_universal_circuit", Item::new).lang("Blank Universal Circuit").register();
	public static ItemEntry<Item> UNIVERSAL_ULV_CIRCUIT = REGISTRATE.item("ulv_universal_circuit", Item::new).lang("ULV Universal Circuit").tag(CustomTags.ULV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_LV_CIRCUIT = REGISTRATE.item("lv_universal_circuit", Item::new).lang("LV Universal Circuit").tag(CustomTags.LV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_MV_CIRCUIT = REGISTRATE.item("mv_universal_circuit", Item::new).lang("MV Universal Circuit").tag(CustomTags.MV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_HV_CIRCUIT = REGISTRATE.item("hv_universal_circuit", Item::new).lang("HV Universal Circuit").tag(CustomTags.HV_CIRCUITS).register();
	/*public static ItemEntry<Item> UNIVERSAL_EV_CIRCUIT = REGISTRATE.item("ev_universal_circuit", Item::new).lang("EV Universal Circuit").tag(CustomTags.EV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_IV_CIRCUIT = REGISTRATE.item("iv_universal_circuit", Item::new).lang("IV Universal Circuit").tag(CustomTags.IV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_LuV_CIRCUIT = REGISTRATE.item("luv_universal_circuit", Item::new).lang("LuV Universal Circuit").tag(CustomTags.LuV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_ZPM_CIRCUIT = REGISTRATE.item("zpm_universal_circuit", Item::new).lang("ZPM Universal Circuit").tag(CustomTags.ZPM_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_UV_CIRCUIT = REGISTRATE.item("uv_universal_circuit", Item::new).lang("UV Universal Circuit").tag(CustomTags.UV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_UHV_CIRCUIT = REGISTRATE.item("uhv_universal_circuit", Item::new).lang("UHV Universal Circuit").tag(CustomTags.UHV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_UEV_CIRCUIT = REGISTRATE.item("uev_universal_circuit", Item::new).lang("UEV Universal Circuit").tag(CustomTags.UEV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_UIV_CIRCUIT = REGISTRATE.item("uiv_universal_circuit", Item::new).lang("UIV Universal Circuit").tag(CustomTags.UIV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_UXV_CIRCUIT = REGISTRATE.item("uxv_universal_circuit", Item::new).lang("UXV Universal Circuit").tag(CustomTags.UXV_CIRCUITS).register();
	public static ItemEntry<Item> UNIVERSAL_OpV_CIRCUIT = REGISTRATE.item("opv_universal_circuit", Item::new).lang("OpV Universal Circuit").tag(CustomTags.OpV_CIRCUITS).register();
	//public static ItemEntry<Item> SPACE_DUST = REGISTRATE.item("space_dust", Item::new).lang("Space Dust").tag(Tags.Items.DUSTS).register();*/

	public static void init() {

	}
}
