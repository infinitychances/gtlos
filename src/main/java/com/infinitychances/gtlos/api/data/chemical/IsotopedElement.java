package com.infinitychances.gtlos.api.data.chemical;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.api.data.chemical.material.info.GTLOSMaterialFlags;
import com.infinitychances.gtlos.common.data.WorldElement;
import com.infinitychances.gtlos.common.util.Math;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

public class IsotopedElement extends Element {
	private final @Nullable @Getter WorldElement.DecayHolder decayInfo;
	private final @Getter WorldElement worldElement;
	private final long isotope;

	public IsotopedElement(long protons, long neutrons, long halfLifeSeconds, WorldElement.DecayHolder decayTo) {
		this(protons, neutrons, halfLifeSeconds, decayTo, WorldElement.MAP.get(protons).name()+"-"+(protons+neutrons),
				WorldElement.MAP.get(protons).shortName()+"-"+(protons+neutrons), true);
	}

	public IsotopedElement(long protons, long neutrons, long halfLifeSeconds, WorldElement.DecayHolder decayTo, String name, String symbol, boolean isIsotope) {
		super(protons, neutrons, halfLifeSeconds, decayTo != null ? decayTo.toString() : null,
				name, symbol,
				isIsotope);
		this.decayInfo = decayTo;
		this.worldElement = WorldElement.MAP.get(protons);
		this.isotope = protons + neutrons;
	}

	public Material.Builder makeVialMaterial(MaterialIconSet set) {
		if(this.worldElement.secondary() == -1) {
			return new Material.Builder(GTLOS.id(this.name().toLowerCase()))
					.ingot()
					.liquid(worldElement.liquidTemp())
					.iconSet(set)
					.color(Math.randomAddSubHex(worldElement.color(), calculateSeed()))
					.flags(GTLOSMaterialFlags.GENERATE_VIAL)
					.element(this)
					.langValue(this.name());
		}
		return new Material.Builder(GTLOS.id(this.name().toLowerCase()))
				.ingot()
				.liquid(worldElement.liquidTemp())
				.iconSet(set)
				.color(Math.randomAddSubHex(worldElement.color(), calculateSeed()))
				.secondaryColor(Math.randomAddSubHex(worldElement.secondary(), calculateSeed()))
				.flags(GTLOSMaterialFlags.GENERATE_VIAL)
				.element(this)
				.langValue(this.name());
	}

	public Material.Builder makeVialMaterial() {
		return makeVialMaterial(MaterialIconSet.RADIOACTIVE);
	}

	public Material buildVialMaterial() {
		return makeVialMaterial(MaterialIconSet.RADIOACTIVE).buildAndRegister();
	}

	public Material buildVialMaterial(MaterialIconSet set) {
		return makeVialMaterial(set).buildAndRegister();
	}

	private long calculateSeed() {
		return this.isotope + this.worldElement.name().length() + (this.decayInfo != null ? this.decayInfo.toString().length() : 0) + this.worldElement.shortName().length();
	}
}
