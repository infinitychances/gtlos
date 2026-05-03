package com.infinitychances.gtlos.common.data.models;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.infinitychances.gtlos.GTLOS;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.world.level.block.Block;

public class GTLOSModels {
	public static NonNullBiConsumer<DataGenContext<Block, Block>, RegistrateBlockstateProvider> createCleanroomFilterModel(IFilterType type) {
		return (ctx, prov) ->
				prov.simpleBlock(ctx.getEntry(), prov.models().cubeAll(ctx.getName(), GTLOS.id("block/casings/cleanroom/" + type.getSerializedName())));
	}
}
