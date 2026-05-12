package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import org.jetbrains.annotations.NotNull;

public record WorldElement(String name, String shortName, long protons) {
	public static final WorldElement Hydrogen = new WorldElement("Hydrogen", "H", 1);
	public static final WorldElement Helium = new WorldElement("Helium", "He", 2);
	public static final WorldElement Lithium = new WorldElement("Lithium", "Li", 3);
	public static final WorldElement Beryllium = new WorldElement("Beryllium", "Be", 4);
	public static final WorldElement Boron = new WorldElement("Boron", "B", 5);
	public static final WorldElement Carbon = new WorldElement("Carbon", "C", 6);
	public static final WorldElement Nitrogen = new WorldElement("Nitrogen", "N", 7);
	public static final WorldElement Oxygen = new WorldElement("Oxygen", "O", 8);
	public static final WorldElement Fluorine = new WorldElement("Fluorine", "F", 9);
	public static final WorldElement Neon = new WorldElement("Neon", "Ne", 10);
	public static final WorldElement Sodium = new WorldElement("Sodium", "Na", 11);
	public static final WorldElement Magnesium = new WorldElement("Magnesium", "Mg", 12);
	public static final WorldElement Aluminium = new WorldElement("Aluminium", "Al", 13);
	public static final WorldElement Silicon = new WorldElement("Silicon", "Si", 14);


	public static final WorldElement Mercury = new WorldElement("Mercury", "Hg", 80);
	public static final WorldElement Thallium = new WorldElement("Thallium", "Tl", 81);
	public static final WorldElement Lead = new WorldElement("Lead", "Pb", 82);
	public static final WorldElement Bismuth = new WorldElement("Bismuth", "Bi", 83);
	public static final WorldElement Polonium = new WorldElement("Polonium", "Po", 84);
	public static final WorldElement Astatine = new WorldElement("Astatine", "At", 85);
	public static final WorldElement Radon = new WorldElement("Radon", "Rn", 86);
	public static final WorldElement Francium = new WorldElement("Francium", "Fr", 87);
	public static final WorldElement Radium = new WorldElement("Radium", "Ra", 88);

	public static final WorldElement Thorium = new WorldElement("Thorium", "Th", 90);
	public static final WorldElement Protactinium = new WorldElement("Protactinium", "Pa", 91);
	public static final WorldElement Uranium = new WorldElement("Uranium", "U", 92);

	public Element isotope(long isotope, Isotope decay) {
		return isotope(isotope, decay.toString(), 1);
	}

	public Element stableIsotope(long isotope) {
		return GTLOSElements.makeIsotope(this, null, -1, isotope);
	}

	public Element isotope(long isotope, String decay) {
		return isotope(isotope, decay, decay == null ? -1 : 1);
	}

	public Element isotope(long isotope, Isotope decay, int halfLife) {
		return GTLOSElements.makeIsotope(this, decay.toString(), halfLife, isotope);
	}

	public Element isotope(long isotope, String decay, int halfLife) {
		return GTLOSElements.makeIsotope(this, decay, halfLife, isotope);
	}

	public Isotope isotope(long isotope) {
		return new Isotope(this, isotope);
	}

	public record Isotope(WorldElement primaryElement, long primaryIsotope, WorldElement secondaryElement, long secondaryIsotope) {
		public Isotope(WorldElement primaryElement, long primaryIsotope) {
			this(primaryElement, primaryIsotope, null, 0);
		}

		@Override
		public @NotNull String toString() {
			if(secondaryElement == null) {
				return primaryElement.shortName + "-" + primaryIsotope;
			}
			return primaryElement.shortName + "-" + primaryIsotope + "/" + secondaryElement.shortName + "-" + secondaryIsotope;
		}

		public Isotope or(WorldElement element, long isotope) {
			return new Isotope(primaryElement, primaryIsotope, element, isotope);
		}
	}
}
