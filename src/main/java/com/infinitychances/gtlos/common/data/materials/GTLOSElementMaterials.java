package com.infinitychances.gtlos.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.common.data.GTElements;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.api.data.chemical.material.info.GTLOSMaterialFlags;
import com.infinitychances.gtlos.common.data.GTLOSCreativeModeTab;
import com.infinitychances.gtlos.common.data.GTLOSElements;
import com.infinitychances.gtlos.common.util.Math;

import static com.infinitychances.gtlos.common.data.GTLOSMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;

public class GTLOSElementMaterials {

	public static Material.Builder makeVialMaterial(Element element, int color, int secondaryColor, MaterialIconSet set, int liquidTemp) {
		return new Material.Builder(GTLOS.id(element.name().toLowerCase()))
				.ingot()
				.liquid(liquidTemp)
				.iconSet(set)
				.color(color)
				.secondaryColor(secondaryColor)
				.flags(GTLOSMaterialFlags.GENERATE_VIAL)
				.element(element)
				.langValue(element.name());
	}

	public static Material.Builder makeVialMaterial(Element element, int color, MaterialIconSet set, int liquidTemp) {
		return new Material.Builder(GTLOS.id(element.name().toLowerCase()))
				.ingot()
				.liquid(liquidTemp)
				.iconSet(set)
				.color(color)
				.flags(GTLOSMaterialFlags.GENERATE_VIAL)
				.element(element)
				.langValue(element.name());
	}

	public static void register() {

		Thorium228 = makeVialMaterial(GTLOSElements.Th228, 0x418a3e, 0x214037, RADIOACTIVE, 2023).buildAndRegister();

		//Uranium Series
		Thorium234 = makeVialMaterial(GTLOSElements.Th234, 0x1C3A1D, 0x0A1903, RADIOACTIVE, 2023).buildAndRegister();
		Protactinium234 = makeVialMaterial(GTLOSElements.Pa234, 0xA88364, RADIOACTIVE, 1841).buildAndRegister();
		Uranium234 = makeVialMaterial(GTLOSElements.U234, 0x1C8024, 0x3A3935, RADIOACTIVE, 1405).buildAndRegister();
		Radium226 = makeVialMaterial(GTLOSElements.Ra226, 0x8C8B69, 0x84021D, RADIOACTIVE, 696).buildAndRegister();
		Radon222 = makeVialMaterial(GTLOSElements.Rn222, 0xF538F7, RADIOACTIVE, 202).buildAndRegister();
		Polonium218 = makeVialMaterial(GTLOSElements.Po218,  0x1E3D23, 0x020678, RADIOACTIVE, 527).buildAndRegister();
		Lead214 = makeVialMaterial(GTLOSElements.Pb214, 0x7E667A, 0x281036, RADIOACTIVE, 600).buildAndRegister();
		Bismuth214 = makeVialMaterial(GTLOSElements.Bi214, 0x56E6D4, 0x4A7980, RADIOACTIVE, 545).buildAndRegister();
		Polonium214 = makeVialMaterial(GTLOSElements.Po214, 0x0E3A1E, 0x05FA7A, RADIOACTIVE, 527).buildAndRegister();
		Lead210 = makeVialMaterial(GTLOSElements.Pb210, 0x776885, 0x320C3B, RADIOACTIVE, 600).buildAndRegister();
		Bismuth210 = makeVialMaterial(GTLOSElements.Bi210, 0x59E6DA, 0x4B6F81, RADIOACTIVE, 545).buildAndRegister();
		Polonium210 = makeVialMaterial(GTLOSElements.Po210, 0x133F1E, 0x03FF7A, RADIOACTIVE, 527).buildAndRegister();
		Lead206 = makeVialMaterial(GTLOSElements.Pb206, 0x846F88, 0x28052E, RADIOACTIVE, 600).buildAndRegister();
		Astatine218 = makeVialMaterial(GTLOSElements.At218, 0x682654, 0x0E1734, RADIOACTIVE, 575).buildAndRegister();
		Thallium210 = makeVialMaterial(GTLOSElements.Tl210, 0x5A6A85, 0x785861, RADIOACTIVE, 577).buildAndRegister();
		Mercury206 = makeVialMaterial(GTLOSElements.Hg206, 0xDCDEDA, RADIOACTIVE, 234).buildAndRegister();
		Thallium206 = makeVialMaterial(GTLOSElements.Tl206, 0x646894, 0x875265, RADIOACTIVE, 577).buildAndRegister();

		Illonium = new Material.Builder(GTLOS.id("illonium"))
				.liquid(new FluidBuilder().temperature(288))
				.ingot()
				.color(0x75b842)
				.appendFlags(GTMaterials.EXT2_METAL, GENERATE_FINE_WIRE, GENERATE_GEAR, GENERATE_SMALL_GEAR)
				.element(GTLOSElements.Il)
				.cableProperties(V[OpV], 32,0, true)
				.iconSet(SHINY)
				.blast(b -> b.temp(15000, BlastProperty.GasTier.HIGHEST).blastStats(VA[UEV], Math.secondsToTicks(120)).vacuumStats(VA[ZPM], Math.secondsToTicks(30)))
				.buildAndRegister();

		EnrichedIllonium = new Material.Builder(GTLOS.id("enriched_illonium"))
				.liquid(new FluidBuilder().temperature(310))
				.color(0x81c54c)
				.element(GTLOSElements.Il1)
				.buildAndRegister();

		Spacium = new Material.Builder(GTLOS.id("spacium"))
				.liquid(new FluidBuilder().temperature(3))
				.ingot()
				.element(GTElements.Sp)
				.iconSet(ROUGH)
				.color(0x24273b)
				.buildAndRegister();
	}
}
