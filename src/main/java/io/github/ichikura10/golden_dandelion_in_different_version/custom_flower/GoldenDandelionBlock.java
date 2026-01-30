package io.github.ichikura10.golden_dandelion_in_different_version.custom_flower;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GoldenDandelionBlock extends BushBlock {

    public GoldenDandelionBlock() {
        super(
                BlockBehaviour.Properties.copy(Blocks.DANDELION)
                        .noCollission()
                        .instabreak()
                        .sound(SoundType.GRASS)
        );
    }
}
