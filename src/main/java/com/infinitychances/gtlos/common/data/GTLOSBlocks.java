package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.block.SimpleCoilType;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.infinitychances.gtlos.GTLOS;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Blocks;

import static com.infinitychances.gtlos.GTLOS.REGISTRATE;

@SuppressWarnings({"unchecked", "rawtypes"})
public class GTLOSBlocks {
	static {
		REGISTRATE.creativeModeTab(() -> GTLOSCreativeModeTab.BLOCKS);

	}

	public static final BlockEntry<CoilBlock> COIL_RUBIDIUM = createCoilBlock("Rubidium Coil", new SimpleCoilType( "rubidium", 16000, 16, 16, 8, ()->GTMaterials.Rubidium, GTLOS.id("block/casings/coils/machine_coil_rubidium")));
	private static BlockEntry<CoilBlock> createCoilBlock(String defaultLang,ICoilType coilType) {
		BlockEntry<CoilBlock> coilBlock = ((BlockBuilder) GTLOS.REGISTRATE.block("%s_coil_block".formatted(coilType.getName()), (p) -> new CoilBlock(p, coilType)).initialProperties(() -> Blocks.IRON_BLOCK).properties((p) -> p.isValidSpawn((state, level, pos, ent) -> false)).addLayer(() -> RenderType::cutoutMipped).blockstate(GTModels.createCoilModel(coilType)).tag(new TagKey[]{CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH}).item().build()).lang(defaultLang).register();
		GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
		return coilBlock;
	}


	public static void init() {}
}
