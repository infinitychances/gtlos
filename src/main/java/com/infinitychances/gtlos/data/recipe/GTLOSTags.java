package com.infinitychances.gtlos.data.recipe;

import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class GTLOSTags {
	public static final TagKey<Item> STEAM_CIRCUITS = TagUtil.createModItemTag("circuits/steam");
	public static final TagKey<Item> UNIVERSAL_CIRCUITS = TagUtil.createModItemTag("circuits/universal");

	public static void init() {

	}
}
