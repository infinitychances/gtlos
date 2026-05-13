package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.infinitychances.gtlos.api.data.chemical.IsotopedElement;

import static com.infinitychances.gtlos.common.data.WorldElement.*;

public class GTLOSElements {
	public static void init() {}

	//Alpha decay ex: U-238(92 protons) -> He-4 + Th-234 (90 protons)
	//Beta- decay ex: Th-230(90 protons) -> 0/-1 e(electron) + Pa-234(91 protons)
	//Beta+ decay ex: Mg-23(12 protons) -> e+ + Na-23(11 protons)
	public static IsotopedElement createAndRegisterI(long protons, long neutrons, long halfLifeSeconds, DecayHolder decayTo) {
		IsotopedElement element = new IsotopedElement(protons, neutrons, halfLifeSeconds, decayTo);
		GTRegistries.ELEMENTS.register(MAP.get(protons).name()+"-"+(protons+neutrons), element);
		return element;
	}
	public static IsotopedElement createAndRegisterI(long protons, long neutrons, long halfLifeSeconds, DecayHolder decayTo, String name, String symbol) {
		IsotopedElement element = new IsotopedElement(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, true);
		GTRegistries.ELEMENTS.register(name, element);
		return element;
	}

	public static IsotopedElement createAndRegister(long protons, long neutrons, long halfLifeSeconds, DecayHolder decayTo, String name, String symbol) {
		IsotopedElement element = new IsotopedElement(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, false);
		GTRegistries.ELEMENTS.register(name, element);
		return element;
	}


	public static IsotopedElement makeS(DecayHolder decay, long halfLife, long pro, long neu) {
		return createAndRegisterI(pro, neu, halfLife, decay);
	}

	public static IsotopedElement make(String name, String symbol, DecayHolder decay, long halfLife, long pro, long neu) {
		return createAndRegister(pro, neu, halfLife, decay, name, symbol);
	}

	public static IsotopedElement make(String name, String symbol, long pro, long neu) {
		return createAndRegister(pro, neu, -1, null, name, symbol);
	}

	public static IsotopedElement makeIsotope(WorldElement element, DecayHolder decay, long halfLife, long isotope) {
		if(isotope < element.protons()) throw new IllegalArgumentException("Isotope number cannot be smaller than amount of protons!" + element.name() +"-" + isotope);
		return makeS(decay, halfLife, element.protons(), isotope - element.protons());
	}

	public static IsotopedElement makeIsotope(WorldElement element, DecayHolder decay, long isotope) {
		if(isotope < element.protons()) throw new IllegalArgumentException("Isotope number cannot be smaller than amount of protons!" + element.name() +"-" + isotope);
		return makeS(decay, 1, element.protons(), isotope - element.protons());
	}

	public static final Element Th228 = Thorium.isotope(228, Radium.isotope(224),60325500);

	//--URANIUM SERIES--

	//U238
	public static final IsotopedElement Th234 = Thorium.isotope(234, Protactinium.isotope(234), 2082240); //90,144
	public static final IsotopedElement Pa234 = Protactinium.isotope(234, Uranium.isotope(234)); //91, 143
	public static final IsotopedElement U234 = Uranium.isotope(234, Thorium.isotope(230)); //92,142
	//Th230 (Base Thorium)
	public static final IsotopedElement Ra226 = Radium.isotope(226, Radon.isotope(222)); //88, 138
	public static final IsotopedElement Rn222 = Radon.isotope(222, Polonium.isotope(218)); //86, 136
	public static final IsotopedElement Po218 = Polonium.isotope(218, Lead.isotope(214).or(Astatine, 218));
	//^ 84, 134 //Also decays into At-218 through b- decay, which turns into Bi-214
	public static final IsotopedElement Pb214 = Lead.isotope(214, Bismuth.isotope(214)); //82, 132
	public static final IsotopedElement Bi214 = Bismuth.isotope(214, Polonium.isotope(214).or(Thallium, 210));
	//^ 83, 131 //Also decays into Tl-210 through a decay, which turns into Pb-210
	public static final IsotopedElement Po214 = Polonium.isotope(214, Lead.isotope(210)); //84, 130
	public static final IsotopedElement Pb210 = Lead.isotope(210, Bismuth.isotope(210).or(Mercury, 206));
	//^ 82, 128 //Also decays into Hg-206 through a decay, which turns into Tl-206
	public static final IsotopedElement Bi210 = Bismuth.isotope(210, Polonium.isotope(210).or(Thallium, 206));
	//^ 83, 127 //Also decays into Tl-206 through a decay, which turns into Pb-206
	public static final IsotopedElement Po210 = Polonium.isotope(210, Lead.isotope(206)); //84, 126
	public static final IsotopedElement Pb206 = Lead.stableIsotope(206); //82, 124

	//END OF LINE //EXTRAS:
	public static final IsotopedElement At218 = Astatine.isotope(218, Bismuth.isotope(214)); //85, 133
	public static final IsotopedElement Tl210 = Thallium.isotope(210, Lead.isotope(210)); //81, 129
	public static final IsotopedElement Hg206 = Mercury.isotope(206, Thallium.isotope(206)); //80, 126
	public static final IsotopedElement Tl206 = Thallium.isotope(206, Lead.isotope(206)); //81, 125

	public static final Element Nx = make("Null", "Nx", 0,0);
	public static final Element Ex = make("Extrenum", "Ex", 121, 194);
	public static final Element Il = make("Illonium", "Il", 176L, 360L);
	public static final Element Il1 = make("Enriched Illonium", "*Il*", 176L, 362L);
	//public static final Element Il524 = makeS( "Illonium", "Il", "Nq", 100, 176L, 352L); //Alpha-Decay
	public static final Element Pn = make("Protonium", "Pn", 1000, 0);
}
