package io.github.ichikura10.golden_dandelion_in_different_version.event;

import io.github.ichikura10.golden_dandelion_in_different_version.Golden_dandelion_in_different_version;
import io.github.ichikura10.golden_dandelion_in_different_version.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Golden_dandelion_in_different_version.MOD_ID)
public class StewEffectHandler {

    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        ItemStack result = event.getCrafting();
        if (!result.is(Items.SUSPICIOUS_STEW)) return;

        boolean usedGoldenDandelion = false;
        Container inv = event.getInventory();

        for (int i = 0; i < inv.getContainerSize(); i++) {
            if (inv.getItem(i).is(ModItems.GOLDEN_DANDELION.get())) {
                usedGoldenDandelion = true;
                break;
            }
        }
        if (!usedGoldenDandelion) return;

        CompoundTag tag = result.getOrCreateTag();
        ListTag effects = new ListTag();

        CompoundTag effectTag = new CompoundTag();
        effectTag.putInt(
                "EffectId",
                net.minecraft.world.effect.MobEffect.getId(
                        net.minecraft.world.effect.MobEffects.SATURATION
                )
        );
        effectTag.putInt("EffectDuration", 7);

        effects.add(effectTag);
        tag.put("Effects", effects);
    }
}