package asia.draxon.ignitecombos.mixin;

import asia.draxon.ignitecombos.combo.ComboTracker;
import asia.draxon.ignitecombos.IgniteCombos;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ClientTickMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void ignitecombos$tick(CallbackInfo ci) {
        ComboTracker.getInstance().tick();
        IgniteCombos.getSoundManager().tick();
    }
}
