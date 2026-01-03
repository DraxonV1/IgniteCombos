package asia.draxon.ignitecombos.sound;

import asia.draxon.ignitecombos.IgniteCombos;
import asia.draxon.ignitecombos.config.ComboConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ComboSoundManager {
    public static final SoundEvent PREDATOR_SOUND = SoundEvents.ENTITY_WITHER_SPAWN;

    public void tick() {
        // intentionally empty for now
    }

    public void onComboBreak() {
        // add sound later
    }

    public void onGradeUpgrade() {
        boolean isPredator = IgniteCombos.getConfig().preset == ComboConfig.ConfigPreset.PREDATOR;
        if (isPredator) {
            playSound(PREDATOR_SOUND, 1.0f);
        }
    }

    private void playSound(SoundEvent sound, float volume) {
        MinecraftClient.getInstance().execute(() -> {
            if (MinecraftClient.getInstance().player != null) {
                MinecraftClient.getInstance().player.playSound(sound, volume, 1.0f);
            }
        });
    }
}
