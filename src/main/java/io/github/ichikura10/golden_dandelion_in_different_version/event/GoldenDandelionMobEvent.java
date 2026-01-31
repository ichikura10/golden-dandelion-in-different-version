package io.github.ichikura10.golden_dandelion_in_different_version.event;

import io.github.ichikura10.golden_dandelion_in_different_version.Golden_dandelion_in_different_version;
import io.github.ichikura10.golden_dandelion_in_different_version.item.ModItems;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Golden_dandelion_in_different_version.MOD_ID)
public class GoldenDandelionMobEvent {

    @SubscribeEvent
    public static void onUseGoldenDandelion(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getTarget() instanceof AgeableMob mob)) return;

        if (mob.getAge() >= 0) return;

        ItemStack stack = event.getItemStack();
        if (!stack.is(ModItems.GOLDEN_DANDELION.get())) return;

        if (!mob.getPersistentData().getBoolean("goldenDandelionLockAge")) {
            mob.getPersistentData().putBoolean(
                    "goldenDandelionLockAge",
                    true
            );

            // 子供にする
            mob.setAge(-24000);
        }
        else {
            mob.getPersistentData().putBoolean(
                    "goldenDandelionLockAge",
                    false
            );
        }

        if (!event.getLevel().isClientSide()) {
            stack.shrink(1);
        }

        event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        if (!(event.getEntity() instanceof AgeableMob mob)) return;

        if (!mob.getPersistentData().getBoolean("goldenDandelionLockAge")) return;

        // ageが0つまり大人になった瞬間子供に戻す
        if (mob.getAge() >= 0) {
            mob.setAge(-24000);
        }
    }
}
