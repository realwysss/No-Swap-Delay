package com.wayysss.noswap.mixin;

import com.wayysss.noswap.cfg;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class mcclmixin {

    @Shadow
    private int itemUseCooldown;

    @Shadow
    public ClientPlayerEntity player;

    @Shadow
    public ClientWorld world;

    @Unique
    private int s = -1;

    @Inject(method = "tick", at = @At("HEAD"))
    private void tck(CallbackInfo c) {
        if (!cfg.on) return;
        if (this.player != null && this.world != null) {
            int cS = this.player.getInventory().getSelectedSlot();
            if (this.s != -1 && this.s != cS) {
                int t = com.wayysss.noswap.cfg.min + (com.wayysss.noswap.cfg.max > com.wayysss.noswap.cfg.min ? (int)(Math.random() * ((com.wayysss.noswap.cfg.max - com.wayysss.noswap.cfg.min) + 1)) : 0);
                if (this.itemUseCooldown > t) {
                    this.itemUseCooldown = t;
                }
            }
            this.s = cS;
        }
    }
}





