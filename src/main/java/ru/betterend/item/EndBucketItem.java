package ru.betterend.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.FishBucketItem;
import net.minecraft.world.level.material.Fluids;
import ru.betterend.patterns.ModelProvider;
import ru.betterend.patterns.Patterns;
import ru.betterend.registry.EndItems;

public class EndBucketItem extends FishBucketItem implements ModelProvider {
	public EndBucketItem(EntityType<?> type) {
		super(type, Fluids.WATER, EndItems.makeItemSettings().stacksTo(1));
	}

	@Override
	public String getModelString(String name) {
		return Patterns.createJson(Patterns.ITEM_GENERATED, name);
	}
}
