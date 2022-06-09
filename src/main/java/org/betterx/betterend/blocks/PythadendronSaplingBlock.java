package org.betterx.betterend.blocks;

import org.betterx.betterend.blocks.basis.PottableFeatureSapling;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndFeatures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PythadendronSaplingBlock extends PottableFeatureSapling {
    public PythadendronSaplingBlock() {
        super((state) -> EndFeatures.PYTHADENDRON_TREE);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).is(EndBlocks.CHORUS_NYLIUM);
    }

    @Override
    public boolean canPlantOn(Block block) {
        return block == EndBlocks.CHORUS_NYLIUM;
    }
}
