package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.block.SimpleCoilType;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.block.PollutionroomFilterType;
import com.infinitychances.gtlos.common.data.models.GTLOSModels;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.infinitychances.gtlos.GTLOS.REGISTRATE;

@SuppressWarnings({"unchecked", "rawtypes"})
public class GTLOSBlocks {
	static {
		REGISTRATE.creativeModeTab(() -> GTLOSCreativeModeTab.BLOCKS);

	}

	private static BlockEntry<Block> createCleanroomFilter(IFilterType filterType, boolean addToFilters) {
		var filterBlock = REGISTRATE.block(filterType.getSerializedName(), Block::new)
				.initialProperties(() -> Blocks.IRON_BLOCK)
				.properties(properties -> properties.strength(2.0f, 8.0f).sound(SoundType.METAL)
						.isValidSpawn((blockState, blockGetter, blockPos, entityType) -> false))
				.blockstate(GTLOSModels.createCleanroomFilterModel(filterType))
				.tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH, CustomTags.TOOL_TIERS[1])
				.item(BlockItem::new)
				.build()
				.register();
		var ignored = addToFilters ? GTCEuAPI.CLEANROOM_FILTERS.put(filterType, filterBlock) : null;
		return filterBlock;
	}

	private static BlockEntry<Block> createBasicBlock(String name) {
		List<String> array = Arrays.stream(name.split("_")).map((s) -> {
			char first = s.charAt(0);
			String upper = String.valueOf(first).toUpperCase();
			return s.replaceFirst(String.valueOf(first), upper);
		}).toList();
		String defaultLang = String.join(" ", array);
		return createBasicBlock(name, defaultLang);
	}

	private static BlockEntry<Block> createBasicBlock(String name, String defaultLang) {
		return createBasicBlock(name, defaultLang, Block::new);
	}

	private static BlockEntry<Block> createBasicBlock(String name, String defaultLang,
	                                                  NonNullSupplier<Block> supplier) {
		return createBasicBlock(name, defaultLang, Block::new, (p) -> p.isValidSpawn((state, level, pos, ent) -> false), supplier);
	}

	private static <T extends Block> BlockEntry<T> createBasicBlock(String name, String defaultLang,
	                                                                Function<BlockBehaviour.Properties, T> provider) {
		return createBasicBlock(name, defaultLang, provider, () -> Blocks.STONE);
	}

	private static <T extends Block> BlockEntry<T> createBasicBlock(String name, String defaultLang,
	                                                                Function<BlockBehaviour.Properties, T> provider,
	                                                                NonNullUnaryOperator<BlockBehaviour.Properties> op) {
		return createBasicBlock(name, defaultLang, provider, op, () -> Blocks.STONE);

	}

	private static <T extends Block> BlockEntry<T> createBasicBlock(String name, String defaultLang,
	                                                                Function<BlockBehaviour.Properties, T> provider,
	                                                                NonNullSupplier<Block> supplier) {
		return createBasicBlock(name, defaultLang, provider, (p) -> p.isValidSpawn((state, level, pos, ent) -> false), supplier);
	}

	private static <T extends Block> BlockEntry<T> createBasicBlock(String name, String defaultLang,
	                                                                Function<BlockBehaviour.Properties, T> provider,
	                                                                NonNullUnaryOperator<BlockBehaviour.Properties> op,
	                                                                NonNullSupplier<Block> propSupplier) {
		return REGISTRATE.block(name, provider::apply)
				.initialProperties(propSupplier)
				.properties(op)
				.lang(defaultLang).register();
	}

	private static BlockEntry<CoilBlock> createCoilBlock(String defaultLang,ICoilType coilType) {
		BlockEntry<CoilBlock> coilBlock = ((BlockBuilder) REGISTRATE.block("%s_coil_block".formatted(coilType.getName()), (p) -> new CoilBlock(p, coilType)).initialProperties(() -> Blocks.IRON_BLOCK).properties((p) -> p.isValidSpawn((state, level, pos, ent) -> false)).addLayer(() -> RenderType::cutoutMipped).blockstate(GTModels.createCoilModel(coilType)).tag(new TagKey[]{CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH}).item().build()).lang(defaultLang).register();
		GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
		return coilBlock;
	}

	public static final BlockEntry<CoilBlock> COIL_RUBIDIUM = createCoilBlock("Rubidium Coil", new SimpleCoilType( "rubidium", 16000, 16, 16, 8, ()->GTMaterials.Rubidium, GTLOS.id("block/casings/coils/machine_coil_rubidium")));
	public static final BlockEntry<Block> POLLUTING_FILTER = createCleanroomFilter(PollutionroomFilterType.POLLUTION_CASING, false);


	public static void init() {
	}
}
