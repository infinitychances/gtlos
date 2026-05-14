package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.common.data.GTMaterials;
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

	public static final WorldElement Hydrogen = new WorldElement("Hydrogen", "H", 1, 0x0000B5, -1, 20);
	public static final WorldElement Helium = new WorldElement("Helium", "He", 2,0xFCFF90 , -1, 4);
	public static final WorldElement Lithium = new WorldElement("Lithium", "Li", 3, 0xD7E7EE, 0xBDC7DB, 454);
	public static final WorldElement Beryllium = new WorldElement("Beryllium", "Be", 4, 0x73d73d, 0x184537, 1560);
	public static final WorldElement Boron = new WorldElement("Boron", "B", 5, 0xBFFDBF, 0x6D7058, 2325);
	public static final WorldElement Carbon = new WorldElement("Carbon", "C", 6, 0x333030, 0x221c1c, 4600);
	public static final WorldElement Nitrogen = new WorldElement("Nitrogen", "N", 7, 0x00BFC1, -1, 77);
	public static final WorldElement Oxygen = new WorldElement("Oxygen", "O", 8, 0x4CC3FF, -1, 85);
	public static final WorldElement Fluorine = new WorldElement("Fluorine", "F", 9, 0x467cab, 0x75a8d5, 53);
	public static final WorldElement Neon = new WorldElement("Neon", "Ne", 10, 0xFAB4B4, -1, 24);
	public static final WorldElement Sodium = new WorldElement("Sodium", "Na", 11, 0x7c80ff, 0x2b30a3, 371);
	public static final WorldElement Magnesium = new WorldElement("Magnesium", "Mg", 12, 0xd6e3ff, 0x594d19, 923);
	public static final WorldElement Aluminium = new WorldElement("Aluminium", "Al", 13, 0x7db9d8, 0x756ac9c, 933);
	public static final WorldElement Silicon = new WorldElement("Silicon", "Si", 14, 0x707078, 0x10293b, 1687);
	public static final WorldElement Phosphorus = new WorldElement("Phosphorus", "P", 15, 0x77332c, 0x220202, 317);
	public static final WorldElement Sulfur = new WorldElement("Sulfur", "S", 16, 0xfdff31, 0xffb400, 388);
	public static final WorldElement Chlorine = new WorldElement("Chlorine", "Cl", 17, 0x215759, 0x38a1a2, 172);
	public static final WorldElement Argon = new WorldElement("Argon", "Ar", 18,0x00FF00, -1, 84);
	public static final WorldElement Potassium = new WorldElement("Potassium", "K", 19, 0xd2e1f2, 0x6189b8, 337);
	public static final WorldElement Calcium = new WorldElement("Calcium", "Ca", 20, 0xFFF5DE, 0xa4a4a4, 1115);
	public static final WorldElement Scandium = new WorldElement("Scandium", "Sc", 21,0xb1b2ac, 0x1c3433, 1814);
	public static final WorldElement Titanium = new WorldElement("Titanium", "Ti", 22, 0xed8eea, 0xff64bc, 1941);
	public static final WorldElement Vanadium = new WorldElement("Vanadium", "V", 23, 0x696d76, 0x240808, 2183);
	public static final WorldElement Chrome = new WorldElement("Chrome", "Cr", 24,0xf3e0ea, 0x441F2E, 2180);
	public static final WorldElement Manganese = new WorldElement("Manganese", "Mn", 25, 0x88a669, 0xCDE1B9, 1519);
	public static final WorldElement Iron = new WorldElement("Iron", "Fe", 26);
	public static final WorldElement Cobalt = new WorldElement("Cobalt", "Co", 27);
	public static final WorldElement Nickel = new WorldElement("Nickel", "Ni", 28);
	public static final WorldElement Copper = new WorldElement("Copper", "Cu", 29);
	public static final WorldElement Zinc = new WorldElement("Zinc", "Zn", 30);
	public static final WorldElement Gallium = new WorldElement("Gallium", "Ga", 31);
	public static final WorldElement Germanium = new WorldElement("Germanium", "Ge", 32);
	public static final WorldElement Arsenic = new WorldElement("Arsenic", "As", 33);
	public static final WorldElement Selenium = new WorldElement("Selenium", "Se", 34);
	public static final WorldElement Bromine = new WorldElement("Bromine", "Br", 35);
	public static final WorldElement Krypton = new WorldElement("Krypton", "Kr", 36);
	public static final WorldElement Rubidium = new WorldElement("Rubidium", "Rb", 37);
	public static final WorldElement Strontium = new WorldElement("Strontium", "Sr", 38);
	public static final WorldElement Yttrium = new WorldElement("Yttrium", "Y", 39);
	public static final WorldElement Zirconium = new WorldElement("Zirconium", "Zr", 40);
	public static final WorldElement Niobium = new WorldElement("Niobium", "Nb", 41);
	public static final WorldElement Molybdenum = new WorldElement("Molybdenum", "Mo", 42);
	public static final WorldElement Technetium = new WorldElement("Technetium", "Tc", 43);
	public static final WorldElement Ruthenium = new WorldElement("Ruthenium", "Ru", 44);
	public static final WorldElement Rhodium = new WorldElement("Rhodium", "Rh", 45);
	public static final WorldElement Palladium = new WorldElement("Palladium", "Pd", 46);
	public static final WorldElement Silver = new WorldElement("Silver", "Ag", 47);
	public static final WorldElement Cadmium = new WorldElement("Cadmium", "Cd", 48);
	public static final WorldElement Indium = new WorldElement("Indium", "In", 49);
	public static final WorldElement Tin = new WorldElement("Tin", "Sn", 50);
	public static final WorldElement Antimony = new WorldElement("Antimony", "Sb", 51);
	public static final WorldElement Tellurium = new WorldElement("Tellurium", "Te", 52);
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement
	public static final WorldElement


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
