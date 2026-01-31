package io.github.ichikura10.golden_dandelion_in_different_version.item;

import io.github.ichikura10.golden_dandelion_in_different_version.Golden_dandelion_in_different_version;
import io.github.ichikura10.golden_dandelion_in_different_version.block.ModBlocks;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SuspiciousStewItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Golden_dandelion_in_different_version.MOD_ID );

    public static final RegistryObject<Item> GOLDEN_DANDELION = ITEMS.register("golden_dandelion",() -> new BlockItem(ModBlocks.GOLDEN_DANDELION.get(), new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_DANDELION_STEW =
            ITEMS.register("golden_dandelion_stew",
                    () -> new SuspiciousStewItem(
                            new Item.Properties().stacksTo(1).food(Foods.SUSPICIOUS_STEW)
                    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
