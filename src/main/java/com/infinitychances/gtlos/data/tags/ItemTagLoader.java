package com.infinitychances.gtlos.data.tags;

import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.infinitychances.gtlos.data.recipe.GTLOSTags;
import com.tterrag.registrate.providers.RegistrateItemTagsProvider;

public class ItemTagLoader {
	public static void init(RegistrateItemTagsProvider provider) {
		provider.addTag(CustomTags.CIRCUITS).replace(true)
				.addTag(GTLOSTags.STEAM_CIRCUITS)
				.addTag(CustomTags.ULV_CIRCUITS)
				.addTag(CustomTags.LV_CIRCUITS)
				.addTag(CustomTags.MV_CIRCUITS)
				.addTag(CustomTags.HV_CIRCUITS)
				.addTag(CustomTags.EV_CIRCUITS)
				.addTag(CustomTags.IV_CIRCUITS)
				.addTag(CustomTags.LuV_CIRCUITS)
				.addTag(CustomTags.ZPM_CIRCUITS)
				.addTag(CustomTags.UV_CIRCUITS)
				.addTag(CustomTags.UHV_CIRCUITS)
				.addOptionalTag(CustomTags.UEV_CIRCUITS.location())
				.addOptionalTag(CustomTags.UIV_CIRCUITS.location())
				.addOptionalTag(CustomTags.UXV_CIRCUITS.location())
				.addOptionalTag(CustomTags.OpV_CIRCUITS.location())
				.addOptionalTag(CustomTags.MAX_CIRCUITS.location());
	}
}
