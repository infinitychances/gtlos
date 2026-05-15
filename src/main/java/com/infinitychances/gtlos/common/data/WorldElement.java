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
	public static final WorldElement Iron = new WorldElement("Iron", "Fe", 26,0xEEEEEE, 0x979797, 1811);
	public static final WorldElement Cobalt = new WorldElement("Cobalt", "Co", 27, 0x5050FA, 0x2d2d7a, 1768);
	public static final WorldElement Nickel = new WorldElement("Nickel", "Ni", 28, 0xccdff5, 0x59563A, 1728);
	public static final WorldElement Copper = new WorldElement("Copper", "Cu", 29, 0xE77C56, 0xE4673E, 1358);
	public static final WorldElement Zinc = new WorldElement("Zinc", "Zn", 30, 0xEBEBFA, 0x232C30, 693);
	public static final WorldElement Gallium = new WorldElement("Gallium", "Ga", 31, 0x7a84ca, 0x13132e, 303);
	public static final WorldElement Germanium = new WorldElement("Germanium", "Ge", 32, 0x4a4a4a, 0x2D2612, 1211);
	public static final WorldElement Arsenic = new WorldElement("Arsenic", "As", 33, 0x9c9c8d, 0x676756, 1090);
	public static final WorldElement Selenium = new WorldElement("Selenium", "Se", 34, 0xffdf77, 0x055d28, 494);
	public static final WorldElement Bromine = new WorldElement("Bromine", "Br", 35, 0x912200, 0x080101, 266);
	public static final WorldElement Krypton = new WorldElement("Krypton", "Kr", 36, 0x80FF80, -1, 116);
	public static final WorldElement Rubidium = new WorldElement("Rubidium", "Rb", 37, 0xde0f0f, 0x3a1f1f, 313);
	public static final WorldElement Strontium = new WorldElement("Strontium", "Sr", 38, 0x7a7953, 0x4c0b06, 1050);
	public static final WorldElement Yttrium = new WorldElement("Yttrium", "Y", 39, 0x7d8072, 0x15161A, 1799);
	public static final WorldElement Zirconium = new WorldElement("Zirconium", "Zr", 40, 0xB99B7E, 0x271813, 2125);
	public static final WorldElement Niobium = new WorldElement("Niobium", "Nb", 41, 0xb494b4, 0x4b3f4d, 2750);
	public static final WorldElement Molybdenum = new WorldElement("Molybdenum", "Mo", 42, 0xc1c1ce, 0x404068, 2896);
	public static final WorldElement Technetium = new WorldElement("Technetium", "Tc", 43, 0x7430e1, 0x7430e1, 2430);
	public static final WorldElement Ruthenium = new WorldElement("Ruthenium", "Ru", 44, 0xa2cde0, 0x3c7285, 2607);
	public static final WorldElement Rhodium = new WorldElement("Rhodium", "Rh", 45, 0xfd46b1, 0xDC0C58, 2237);
	public static final WorldElement Palladium = new WorldElement("Palladium", "Pd", 46, 0xbd92b5, 0x535b14, 1828);
	public static final WorldElement Silver = new WorldElement("Silver", "Ag", 47, 0xDCDCFF, 0x5a4705, 1235);
	public static final WorldElement Cadmium = new WorldElement("Cadmium", "Cd", 48, 0x636377, 0x431a34, 594);
	public static final WorldElement Indium = new WorldElement("Indium", "In", 49, 0x5c3588, 0x2b0b4a, 430);
	public static final WorldElement Tin = new WorldElement("Tin", "Sn", 50, 0xfafeff, 0x4e676c, 505);
	public static final WorldElement Antimony = new WorldElement("Antimony", "Sb", 51, 0xEAEAFF, 0x8181BD, 904);
	public static final WorldElement Tellurium = new WorldElement("Tellurium", "Te", 52, 0x8fea66, 0x00bfff, 723);
	public static final WorldElement Iodine = new WorldElement("Iodine", "I", 53, 0x3e4467, 0x021e40, 387);
	public static final WorldElement Xenon = new WorldElement("Xenon", "Xe", 54, 0x00FFFF, -1, 161);
	public static final WorldElement Caesium = new WorldElement("Caesium", "Cs", 55, 0xd1821c, 0x231f14, 302);
	public static final WorldElement Barium = new WorldElement("Barium", "Ba", 56, 0xede192, 0xA7AD4D, 1000);
	public static final WorldElement Lanthanum = new WorldElement("Lanthanum", "La", 57, 0xd17d50, 0x4a3560, 1193);
	public static final WorldElement Cerium = new WorldElement("Cerium", "Ce", 58, 0x87917D, 0x5e6458, 1068);
	public static final WorldElement Praseodymium = new WorldElement("Praseodymium", "Pr", 59, 0x718060, 0x3f3447, 1204);
	public static final WorldElement Neodymium = new WorldElement("Neodymium", "Nd", 60, 0x6c5863, 0x2c1919, 1295);
	public static final WorldElement Promethium = new WorldElement("Promethium", "Pm", 61, 0x814947, 0xd0ff71, 1315);
	public static final WorldElement Samarium = new WorldElement("Samarium", "Sm", 62, 0xc2c289, 0x235254, 1345);
	public static final WorldElement Europium = new WorldElement("Europium", "Eu", 63, 0x20FFFF, 0x429393, 1099);
	public static final WorldElement Gadolinium = new WorldElement("Gadolinium", "Gd", 64, 0x828a7a, 0x363420, 1585);
	public static final WorldElement Terbium = new WorldElement("Terbium", "Tb", 65, 0xcedab4, 0x263640, 1629);
	public static final WorldElement Dysprosium = new WorldElement("Dysprosium", "Dy", 66, 0x6a664b, 0x423307, 1680);
	public static final WorldElement Holmium = new WorldElement("Holmium", "Ho", 67, 0xf6fc9c, 0xa3a3a3, 1734);
	public static final WorldElement Erbium = new WorldElement("Erbium", "Er", 68, 0xECCBDB, 0x5D625A, 1802);
	public static final WorldElement Thulium = new WorldElement("Thulium", "Tm", 69, 0x467681, 0x682C2C, 1818);
	public static final WorldElement Ytterbium = new WorldElement("Ytterbium", "Yb", 70, 0xA7A7A7, -1, 1097);
	public static final WorldElement Lutetium = new WorldElement("Lutetium", "Lu", 71, 0x00ccff, 0x4c687a, 1925);
	public static final WorldElement Hafnium = new WorldElement("Hafnium", "Hf", 72, 0x99999A, 0x2b4a3a, 2506);
	public static final WorldElement Tantalum = new WorldElement("Tantalum", "Ta", 73, 0xa8a7c6, 0x1F2B20, 3290);
	public static final WorldElement Tungsten = new WorldElement("Tungsten", "W", 74, 0x3b3a32, 0x2A2800, 3695);
	public static final WorldElement Rhenium = new WorldElement("Rhenium", "Re", 75, 0xCBCFD7, 0x37393D, 3459);
	public static final WorldElement Osmium = new WorldElement("Osmium", "Os", 76, 0x54afff, 0x6e6eff, 3306);
	public static final WorldElement Iridium = new WorldElement("Iridium", "Ir", 77, 0x99fede, 0x6CD1CF, 2719);
	public static final WorldElement Platinum = new WorldElement("Platinum", "Pt", 78, 0xfff4ba, 0x8d8d71, 2041);
	public static final WorldElement Gold = new WorldElement("Gold", "Au", 79, 0xfdf55f, 0xf25833, 1337);
	public static final WorldElement Mercury = new WorldElement("Mercury", "Hg", 80, 0xE6DCDC, -1, 234);
	public static final WorldElement Thallium = new WorldElement("Thallium", "Tl", 81, 0x5D6B8E, 0x815B63, 577);
	public static final WorldElement Lead = new WorldElement("Lead", "Pb", 82, 0x7E6f82, 0x290633, 600);
	public static final WorldElement Bismuth = new WorldElement("Bismuth", "Bi", 83, 0x5FDDDD, 0x517385, 545);
	public static final WorldElement Polonium = new WorldElement("Polonium", "Po", 84, 0x163b27, 0x00ff78, 527);
	public static final WorldElement Astatine = new WorldElement("Astatine", "At", 85, 0x65204f, 0x17212b, 575);
	public static final WorldElement Radon = new WorldElement("Radon", "Rn", 86, 0xFF39FF, -1, 202);
	public static final WorldElement Francium = new WorldElement("Francium", "Fr", 87, 0xAAAAAA, 0x0000FF, 300);
	public static final WorldElement Radium = new WorldElement("Radium", "Ra", 88, 0x838361, 0x89ff21, 973);
	public static final WorldElement Actinium = new WorldElement("Actinium", "Ac", 89, 0xC3D1FF, 0x397090,1500);
	public static final WorldElement Thorium = new WorldElement("Thorium", "Th", 90, 0x25411b, 0x051E05, 2023);
	public static final WorldElement Protactinium = new WorldElement("Protactinium", "Pa", 91, 0xA78B6D, -1, 1841);
	public static final WorldElement Uranium = new WorldElement("Uranium", "U", 92, 0x1d891d, 0x33342c, 1405);
	public static final WorldElement Neptunium = new WorldElement("Neptunium", "Np", 93, 0x284D7B, -1, 912);
	public static final WorldElement Plutonium = new WorldElement("Plutonium", "Pu", 94, 0xba2727, 0x222730, 913);
	public static final WorldElement Americium = new WorldElement("Americium", "Am", 95, 0x287869, -1, 1449);
	public static final WorldElement Curium = new WorldElement("Curium", "Cm", 96, 0x7B544E, -1, 1613);
	public static final WorldElement Berkelium = new WorldElement("Berkelium", "Bk", 97, 0x645A88, -1, 1259);
	public static final WorldElement Californium = new WorldElement("Californium", "Cf", 98, 0xA85A12, -1, 1173);
	public static final WorldElement Einsteinium = new WorldElement("Einsteinium", "Es", 99, 0xCE9F00, -1, 1133);
	public static final WorldElement Fermium = new WorldElement("Fermium", "Fm", 100, 0xc99fe7, 0x890085, 1800); //PREDICTED PAST HERE FOR REAL ELEMENTS
	public static final WorldElement Mendelevium = new WorldElement("Mendelevium", "Md", 101, 0x1D4ACF, -1, 1100);
	public static final WorldElement Nobelium = new WorldElement("Nobelium", "No", 102, 0x3E4758, 0x43DEFF, 1100);
	public static final WorldElement Lawrencium = new WorldElement("Lawrencium", "Lr", 103, 0x5D7575, -1, 1900);
	public static final WorldElement Rutherfordium = new WorldElement("Rutherfordium", "Rf", 104, 0x6b6157, 0xFFF6A1, 2400);
	public static final WorldElement Dubnium = new WorldElement("Dubnium", "Db", 105, 0xc7ddde, 0x00f3ff, 3000); //ESTIMATED PAST HERE FOR REAL ELEMENTS
	public static final WorldElement Seaborgium = new WorldElement("Seaborgium", "Sg", 106, 0x19C5FF, 0xff19b2, 3400);
	public static final WorldElement Bohrium = new WorldElement("Bohrium", "Bh", 107, 0xde67ff, 0xDC57FF, 3250);
	public static final WorldElement Hassium = new WorldElement("Hassium", "Hs", 108, 0x738786, 0x62ffd5, 2600);
	public static final WorldElement Meitnerium = new WorldElement("Meitnerium", "Mt", 109, 0x4F3C82, 0x6E90FF, 2100);
	public static final WorldElement Darmstadtium = new WorldElement("Darmstadtium", "Ds", 110, 0x578062, -1, 1900);
	public static final WorldElement Roentgenium = new WorldElement("Roentgenium", "Rg", 111, 0x388c48, 0x198a92, 1400);
	public static final WorldElement Copernicium = new WorldElement("Copernicium", "Cn", 112, 0x565c5d, 0xffd34b, 500);
	public static final WorldElement Nihonium = new WorldElement("Nihonium", "Nh", 113, 0x323957, 0xBFABFF, 600);
	public static final WorldElement Flerovium = new WorldElement("Flerovium", "Fl", 114, 0x2a384e, 0xd2ff00, 600);
	public static final WorldElement Moscovium = new WorldElement("Moscovium", "Mc", 115, 0x2A1B40, 0xBD91FF, 500);
	public static final WorldElement Livermorium = new WorldElement("Livermorium", "Lv", 116, 0x939393, 0xff5e5e, 400);
	public static final WorldElement Tennessine = new WorldElement("Tennessine", "Ts", 117, 0x785cc4, 0x7959d4, 300);
	public static final WorldElement Oganesson = new WorldElement("Oganesson", "Og", 118, 0x443936, 0xFF1DBD, 210);
	public static final WorldElement Tritanium = new WorldElement("Tritanium", "Tr", 119, 0xC35769, 0x210840, 25000);
	public static final WorldElement Duranium = new WorldElement("Duranium", "Dr", 120, 0xF3E7A9, 0x9C9487, 7500);




	public static final WorldElement Trinium = new WorldElement("Trinium", "Ke", 125, 0x81808A, 0x351d4b, 6922);

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
