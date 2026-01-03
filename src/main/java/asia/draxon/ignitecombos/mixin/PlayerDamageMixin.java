package asia.draxon.ignitecombos.mixin;

import asia.draxon.ignitecombos.combo.ComboTracker;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerDamageMixin {

    @Inject(method = "damage", at = @At("HEAD"))
    private void ignitecombos$onDamage(
            ServerWorld world,
            DamageSource source,
            float amount,
            CallbackInfoReturnable<Boolean> cir
    ) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (player.getWorld().isClient() && player.isMainPlayer()) {
            ComboTracker.getInstance().onDamaged();
        }
    }
}
