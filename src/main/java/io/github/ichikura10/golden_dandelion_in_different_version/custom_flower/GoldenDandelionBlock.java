package io.github.ichikura10.golden_dandelion_in_different_version.custom_flower;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GoldenDandelionBlock extends BushBlock {

    public GoldenDandelionBlock() {
        super(
                BlockBehaviour.Properties.copy(Blocks.DANDELION)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level,
                               BlockPos pos, CollisionContext context) {
        return Blocks.DANDELION.getShape(state, level, pos, context);
    }
}
