package io.github.ichikura10.golden_dandelion_in_different_version.block;

import io.github.ichikura10.golden_dandelion_in_different_version.Golden_dandelion_in_different_version;
import io.github.ichikura10.golden_dandelion_in_different_version.custom_flower.GoldenDandelionBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Golden_dandelion_in_different_version.MOD_ID);

    public static final RegistryObject<Block> GOLDEN_DANDELION =
            BLOCKS.register("golden_dandelion", GoldenDandelionBlock::new);
}

