package com.infinitychances.gtlos.common.data;

import com.infinitychances.gtlos.api.data.chemical.IsotopedElement;
import org.jetbrains.annotations.NotNull;
import oshi.util.tuples.Pair;

import java.util.*;

public record WorldElement(String name, String shortName, long protons, int color, int secondary, int liquidTemp) {
	public WorldElement(String name, String shortName, long protons, int color, int secondary, int liquidTemp) {
		this.name = name;
		this.shortName = shortName;
		this.protons = protons;
		this.color = color;
		this.secondary = secondary;
		this.liquidTemp = liquidTemp;
		MAP.put(protons, this);
	}
	public static final Map<Long, WorldElement> MAP = new HashMap<>();

	/*public static final WorldElement Hydrogen = new WorldElement("Hydrogen", "H", 1);
	public static final WorldElement Helium = new WorldElement("Helium", "He", 2);
	public static final WorldElement Lithium = new WorldElement("Lithium", "Li", 3, 0xD7E7EE, 0xBDC7DB, 454);
	public static final WorldElement Beryllium = new WorldElement("Beryllium", "Be", 4, 0x73d73d, 0x184537, 1560);
	public static final WorldElement Boron = new WorldElement("Boron", "B", 5, 0xBFFDBF, 0x6D7058, );
	public static final WorldElement Carbon = new WorldElement("Carbon", "C", 6);
	public static final WorldElement Nitrogen = new WorldElement("Nitrogen", "N", 7);
	public static final WorldElement Oxygen = new WorldElement("Oxygen", "O", 8);
	public static final WorldElement Fluorine = new WorldElement("Fluorine", "F", 9);
	public static final WorldElement Neon = new WorldElement("Neon", "Ne", 10);
	public static final WorldElement Sodium = new WorldElement("Sodium", "Na", 11);
	public static final WorldElement Magnesium = new WorldElement("Magnesium", "Mg", 12);
	public static final WorldElement Aluminium = new WorldElement("Aluminium", "Al", 13);
	public static final WorldElement Silicon = new WorldElement("Silicon", "Si", 14);*/


	public static final WorldElement Mercury = new WorldElement("Mercury", "Hg", 80, 0xE6DCDC, -1, 234);
	public static final WorldElement Thallium = new WorldElement("Thallium", "Tl", 81, 0x5D6B8E, 0x815B63, 577);
	public static final WorldElement Lead = new WorldElement("Lead", "Pb", 82, 0x7E6f82, 0x290633, 600);
	public static final WorldElement Bismuth = new WorldElement("Bismuth", "Bi", 83, 0x5FDDDD, 0x517385, 545);
	public static final WorldElement Polonium = new WorldElement("Polonium", "Po", 84, 0x163b27, 0x00ff78, 527);
	public static final WorldElement Astatine = new WorldElement("Astatine", "At", 85, 0x65204f, 0x17212b, 575);
	public static final WorldElement Radon = new WorldElement("Radon", "Rn", 86, 0xFF39FF, -1, 202);
	//public static final WorldElement Francium = new WorldElement("Francium", "Fr", 87);
	public static final WorldElement Radium = new WorldElement("Radium", "Ra", 88, 0x838361, 0x89ff21, 973);

	public static final WorldElement Thorium = new WorldElement("Thorium", "Th", 90, 0x25411b, 0x051E05, 2023);
	public static final WorldElement Protactinium = new WorldElement("Protactinium", "Pa", 91, 0xA78B6D, -1, 1841);
	public static final WorldElement Uranium = new WorldElement("Uranium", "U", 92, 0x1d891d, 0x33342c, 1405);

	public IsotopedElement isotope(long isotope, DecayHolder decay) {
		return isotope(isotope, decay, 1);
	}

	public IsotopedElement stableIsotope(long isotope) {
		return GTLOSElements.makeIsotope(this, null, -1, isotope);
	}

	public IsotopedElement isotope(long isotope, DecayHolder decay, int halfLife) {
		return GTLOSElements.makeIsotope(this, decay, halfLife, isotope);
	}

	public DecayHolder isotope(long isotope) {
		return new DecayHolder(this, isotope);
	}

	public record DecayHolder(List<Pair<WorldElement, Long>> isotopes) {
		public DecayHolder(WorldElement primaryElement, long primaryIsotope) {
			this(Collections.singletonList(new Pair<>(primaryElement, primaryIsotope)));
		}

		@Override
		public @NotNull String toString() {
			StringBuilder builder = new StringBuilder();
			isotopes.forEach((iso) -> {
				if(!builder.isEmpty()) {
					builder.append("/");
				}
				builder.append(iso.getA().shortName).append("-").append(iso.getB());
			});
			return builder.toString();
		}

		public DecayHolder or(WorldElement element, long isotope) {
			ArrayList<Pair<WorldElement, Long>> list = new ArrayList<>(isotopes);
			list.add(new Pair<>(element, isotope));
			return new DecayHolder(Collections.unmodifiableList(list));
		}
	}
}
