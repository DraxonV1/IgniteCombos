package asia.draxon.ignitecombos;

import asia.draxon.ignitecombos.config.ComboConfig;
import asia.draxon.ignitecombos.sound.ComboSoundManager;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IgniteCombos implements ClientModInitializer {

    public static final String MOD_ID = "ignitecombos";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static ComboConfig config;
    private static ComboSoundManager soundManager;

    @Override
    public void onInitializeClient() {
        config = ComboConfig.load();
        soundManager = new ComboSoundManager();
        LOGGER.info("Ignite Combos initialized");
    }

    public static ComboConfig getConfig() {
        return config;
    }

    public static ComboSoundManager getSoundManager() {
        return soundManager;
    }
}
