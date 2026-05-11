package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class GTLOSElements {
	public static void init() {}

	//Alpha decay ex: U-238(92 protons) -> He-4 + Th-234 (90 protons)
	//Beta- decay ex: Th-230(90 protons) -> 0/-1 e(electron) + Pa-234(91 protons)
	//Beta+ decay ex: Mg-23(12 protons) -> e+ + Na-23(11 protons)

	public static Element make(String name, String symbol, String decay, long halfLife, long pro, long neu) {
		return make(name, symbol, decay, halfLife, pro, neu, true);
	}

	public static Element make(String name, String symbol, long pro, long neu) {
		return make(name, symbol, pro, neu, false);
	}

	public static Element make(String name, String symbol, long pro, long neu, boolean isotope) {
		return GTElements.createAndRegister(pro, neu, -1, null, name, symbol, isotope);
	}

	public static Element make(String name, String symbol, String decay, long halfLife, long pro, long neu, boolean isotope) {
		return GTElements.createAndRegister(pro, neu, -1, null, name, symbol, isotope);
	}

	public static final Element Th228 = make("Thorium-228", "Th-228", "Ra",60325500, 90, 138, true);
	public static final Element Nx = make("Null", "Nx", 0,0);
	public static final Element Ex = make("Extrenum", "Ex", 121, 194);
	public static final Element Il = make("Illonium", "Il", 176L, 360L);
	public static final Element Il1 = make("Enriched Illonium", "*Il*", 176L, 362L);
	public static final Element Il352 = make( "Illonium-352", "Il-352", "Nq", 100, 176L, 352L); //Alpha-Decay
	public static final Element Pn = make("Protonium", "Pn", 1000, 0);
}
