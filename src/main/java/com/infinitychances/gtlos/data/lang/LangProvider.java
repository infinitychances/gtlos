package com.infinitychances.gtlos.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangProvider {
	public static void init(RegistrateLangProvider provider) {
		//tooltip
		provider.add("tooltip.gtlos.machine.coke_oven_description", "Making better fuels for Steel and Power");
		provider.add("tooltip.gtlos.machine.coke_oven_parallels", "Gains Parallels with each layer added in length for a maximum of %s parallels total");
		provider.add("gtlos.recipe.pollutionroom.display_name", "Pollutionroom");
		provider.add("gtlos.multiblock.pollutionroom.dirty_amount", "Pollutedness: §a%s%%");
		provider.add("gtlos.multiblock.pollutionroom.clean_state", "Status: §4CLEAN");
		provider.add("gtlos.multiblock.pollutionroom.dirty_state", "Status: §aCONTAMINATED");
		provider.add("tagprefix.vial", "%s Vial");
	}
}
