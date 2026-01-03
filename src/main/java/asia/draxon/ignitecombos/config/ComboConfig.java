package asia.draxon.ignitecombos.config;

import asia.draxon.ignitecombos.IgniteCombos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ComboConfig {
    // Toggles
    public boolean enabled = true;
    public boolean soundEnabled = true;
    public boolean musicEnabled = false;
    public boolean screenShake = false;
    public boolean resetOnDamage = true;
    
    // Sliders
    public long comboTimeout = 700; // milliseconds
    public float uiScale = 1.0f;
    public float soundVolume = 0.5f;
    public float glowIntensity = 0.7f;
    
    // Preset
    public ConfigPreset preset = ConfigPreset.ARCADE;
    
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File(
        FabricLoader.getInstance().getConfigDir().toFile(),
        IgniteCombos.MOD_ID + ".json"
    );
    
    public static ComboConfig load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                return GSON.fromJson(reader, ComboConfig.class);
            } catch (IOException e) {
                IgniteCombos.LOGGER.error("Failed to load config, using defaults", e);
            }
        }
        
        ComboConfig config = new ComboConfig();
        config.save();
        return config;
    }
    
    public void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(this, writer);
        } catch (IOException e) {
            IgniteCombos.LOGGER.error("Failed to save config", e);
        }
    }
    
    public void applyPreset(ConfigPreset preset) {
        this.preset = preset;
        switch (preset) {
            case MINIMAL -> {
                soundEnabled = false;
                musicEnabled = false;
                screenShake = false;
                uiScale = 0.8f;
                glowIntensity = 0.3f;
            }
            case ARCADE -> {
                soundEnabled = true;
                musicEnabled = false;
                screenShake = false;
                uiScale = 1.0f;
                glowIntensity = 0.7f;
            }
            case COMPETITIVE -> {
                soundEnabled = true;
                musicEnabled = false;
                screenShake = true;
                uiScale = 1.2f;
                glowIntensity = 1.0f;
            }
        }
        save();
    }
    
    public enum ConfigPreset {
        MINIMAL,
        ARCADE,
        COMPETITIVE
    }
}