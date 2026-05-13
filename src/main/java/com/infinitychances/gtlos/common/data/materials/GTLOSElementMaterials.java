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
		Thorium234 = GTLOSElements.Th234.makeVialMaterial().buildAndRegister();
		Protactinium234 = GTLOSElements.Pa234.makeVialMaterial().buildAndRegister();
		Uranium234 = GTLOSElements.U234.makeVialMaterial().buildAndRegister();
		Radium226 = GTLOSElements.Ra226.makeVialMaterial().buildAndRegister();
		Radon222 = GTLOSElements.Rn222.makeVialMaterial().buildAndRegister();
		Polonium218 = GTLOSElements.Po218.makeVialMaterial().buildAndRegister();
		Lead214 = GTLOSElements.Pb214.makeVialMaterial().buildAndRegister();
		Bismuth214 = GTLOSElements.Bi214.makeVialMaterial().buildAndRegister();
		Polonium214 = GTLOSElements.Po214.makeVialMaterial().buildAndRegister();
		Lead210 = GTLOSElements.Pb210.makeVialMaterial().buildAndRegister();
		Bismuth210 = GTLOSElements.Bi210.makeVialMaterial().buildAndRegister();
		Polonium210 = GTLOSElements.Po210.makeVialMaterial().buildAndRegister();
		Lead206 = GTLOSElements.Pb206.makeVialMaterial().buildAndRegister();

		Astatine218 = GTLOSElements.At218.makeVialMaterial().buildAndRegister();
		Thallium210 = GTLOSElements.Tl210.makeVialMaterial().buildAndRegister();
		Mercury206 = GTLOSElements.Hg206.makeVialMaterial().buildAndRegister();
		Thallium206 = GTLOSElements.Tl206.makeVialMaterial().buildAndRegister();

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
