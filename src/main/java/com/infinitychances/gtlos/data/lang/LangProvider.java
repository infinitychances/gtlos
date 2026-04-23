package com.infinitychances.gtlos.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangProvider {
	public static void init(RegistrateLangProvider provider) {
		//tooltip
		provider.add("tooltip.gtlos.machine.coke_oven_description", "Making better fuels for Steel and Power");
		provider.add("tooltip.gtlos.machine.coke_oven_parallels", "Gains Parallels with each layer added in length for a maximum of %s parallels total");
	}
}
