package ru.betterend.blocks.basis;

import java.io.Reader;
import java.util.Collections;
import java.util.List;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import ru.betterend.patterns.BlockPatterned;
import ru.betterend.patterns.Patterns;

public class EndPillarBlock extends RotatedPillarBlock implements BlockPatterned {
	public EndPillarBlock(Properties settings) {
		super(settings);
	}
	
	public EndPillarBlock(Block block) {
		super(FabricBlockSettings.copyOf(block));
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		return Collections.singletonList(new ItemStack(this));
	}
	
	@Override
	public String getStatesPattern(Reader data) {
		String texture = Registry.BLOCK.getKey(this).getPath();
		return Patterns.createJson(data, texture, texture);
	}
	
	@Override
	public String getModelPattern(String block) {
		String texture = Registry.BLOCK.getKey(this).getPath();
		return Patterns.createJson(Patterns.BLOCK_PILLAR, texture, texture);
	}
	
	@Override
	public ResourceLocation statePatternId() {
		return Patterns.STATE_PILLAR;
	}
}
