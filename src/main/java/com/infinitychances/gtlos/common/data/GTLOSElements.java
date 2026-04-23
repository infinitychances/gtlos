package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class GTLOSElements {
	public static void init() {}

	public static final Element Il = GTElements.createAndRegister(175L, 291L, -1, null, "Illonium", "Il", false);
	public static final Element Il1 = GTElements.createAndRegister(175L, 299L, 240, null, "Enriched Illonium", "*Il*", true);
	public static final Element Il2 = GTElements.createAndRegister(175L, 299L, 100, "Nq", "Unstable Illonium", "~Il~", true);
	public static final Element Pn = GTElements.createAndRegister(1000L, 0L, -1, null, "Protonium", "Pn", false);
}
