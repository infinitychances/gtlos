package com.infinitychances.gtlos;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import com.infinitychances.gtlos.common.data.GTLOSElements;
import com.infinitychances.gtlos.common.data.GTLOSMaterials;
import com.infinitychances.gtlos.common.data.GTLOSRecipeTypes;
import com.infinitychances.gtlos.common.data.GTLOSRecipeInit;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@SuppressWarnings("unused")
@GTAddon
public class GTLOSGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return GTLOS.REGISTRATE;
    }

    @Override
    public void initializeAddon() {}

    @Override
    public String addonModId() {
        return GTLOS.MOD_ID;
    }

    @Override
    public void registerTagPrefixes() {
        // CustomTagPrefixes.init();
	    TagPrefix.block.setIgnored(GTLOSMaterials.Fluix, AEBlocks.FLUIX_BLOCK);
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        // CustomRecipes.init(provider);
	    GTLOSRecipeTypes.init();
	    GTLOSRecipeInit.init(provider);
    }

    @Override
    public void registerElements() {
        // CustomElements.init();
	    GTLOSElements.init();
    }

    // If you have custom ingredient types, uncomment this & change to match your capability.
    // KubeJS WILL REMOVE YOUR RECIPES IF THESE ARE NOT REGISTERED.
    /*
     * public static final ContentJS<Double> PRESSURE_IN = new ContentJS<>(NumberComponent.ANY_DOUBLE,
     * CustomRecipeCapabilities.PRESSURE, false);
     * public static final ContentJS<Double> PRESSURE_OUT = new ContentJS<>(NumberComponent.ANY_DOUBLE,
     * CustomRecipeCapabilities.PRESSURE, true);
     * 
     * @Override
     * public void registerRecipeKeys(KJSRecipeKeyEvent event) {
     * event.registerKey(CustomRecipeCapabilities.PRESSURE, Pair.of(PRESSURE_IN, PRESSURE_OUT));
     * }
     */
}
