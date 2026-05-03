package com.infinitychances.gtlos.common.block;

import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.infinitychances.gtlos.api.PollutionroomTypes;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public enum PollutionroomFilterType implements IFilterType {
	POLLUTION_CASING("pollution_casing", PollutionroomTypes.POLLUTIONROOM);

	private final @Getter String serializedName;
	private final @Getter CleanroomType cleanroomType;

	PollutionroomFilterType(String casing, CleanroomType type) {
		serializedName = casing;
		cleanroomType = type;
	}
}
