package asia.draxon.ignitecombos.mixin;

import asia.draxon.ignitecombos.IgniteCombos;
import asia.draxon.ignitecombos.combo.ComboTracker;
import asia.draxon.ignitecombos.config.ComboConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerAttackMixin {

    @Inject(method = "attack", at = @At("HEAD"))
    private void ignitecombos$onAttack(Entity target, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (!player.getWorld().isClient()) return;
        if (!player.isMainPlayer()) return;

        if (target instanceof PlayerEntity && target != player) {
            ComboTracker.getInstance().onHit(player, target);

            boolean isPredator = IgniteCombos.getConfig().preset == ComboConfig.ConfigPreset.PREDATOR;
            if (isPredator) {
                player.addVelocity(0, 0.1, 0);
            }
        }
    }
}
