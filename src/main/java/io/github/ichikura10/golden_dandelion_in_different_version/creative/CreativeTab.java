package io.github.ichikura10.golden_dandelion_in_different_version.creative;

import io.github.ichikura10.golden_dandelion_in_different_version.Golden_dandelion_in_different_version;
import io.github.ichikura10.golden_dandelion_in_different_version.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Golden_dandelion_in_different_version.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GOLDEN_DANDELION_IN_DIFFERENT_VERSION = CREATIVE_MODE_TABS.register("golden_dandelion_in_different_version",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GOLDEN_DANDELION.get()))
                    .title(Component.translatable("creativetab.GOLDEN_DANDELION_IN_DIFFERENT_VERSION"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.GOLDEN_DANDELION.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
