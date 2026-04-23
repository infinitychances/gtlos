package com.infinitychances.gtlos.data;

import com.infinitychances.gtlos.data.lang.LangProvider;
import com.tterrag.registrate.providers.ProviderType;

import static com.infinitychances.gtlos.GTLOS.REGISTRATE;

public class GTLOSDatagen {

	public static void init() {
		REGISTRATE.addDataGenerator(ProviderType.LANG, LangProvider::init);
	}
}
