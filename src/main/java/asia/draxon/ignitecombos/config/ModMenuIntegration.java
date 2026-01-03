package asia.draxon.ignitecombos.config;

import asia.draxon.ignitecombos.IgniteCombos;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {
    
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.literal("Ignite Combos Configuration"));
            
            ComboConfig config = IgniteCombos.getConfig();
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();
            
            // General Category
            ConfigCategory general = builder.getOrCreateCategory(Text.literal("General"));
            
            general.addEntry(entryBuilder.startBooleanToggle(
                Text.literal("Enable Combo System"),
                config.enabled
            ).setDefaultValue(true)
            .setSaveConsumer(val -> config.enabled = val)
            .build());
            
            general.addEntry(entryBuilder.startBooleanToggle(
                Text.literal("Reset on Damage"),
                config.resetOnDamage
            ).setDefaultValue(true)
            .setTooltip(Text.literal("Reset combo when you take damage"))
            .setSaveConsumer(val -> config.resetOnDamage = val)
            .build());
            
            general.addEntry(entryBuilder.startLongSlider(
                Text.literal("Combo Timeout (ms)"),
                config.comboTimeout,
                300, 2000
            ).setDefaultValue(700L)
            .setTooltip(Text.literal("Time window between hits"))
            .setSaveConsumer(val -> config.comboTimeout = val)
            .build());
            
            // Visual Category
            ConfigCategory visual = builder.getOrCreateCategory(Text.literal("Visual"));
            
            visual.addEntry(entryBuilder.startFloatField(
                Text.literal("UI Scale"),
                config.uiScale
            ).setDefaultValue(1.0f)
            .setMin(0.5f)
            .setMax(2.0f)
            .setSaveConsumer(val -> config.uiScale = val)
            .build());
            
            visual.addEntry(entryBuilder.startFloatField(
                Text.literal("Glow Intensity"),
                config.glowIntensity
            ).setDefaultValue(0.7f)
            .setMin(0.0f)
            .setMax(1.0f)
            .setSaveConsumer(val -> config.glowIntensity = val)
            .build());
            
            visual.addEntry(entryBuilder.startBooleanToggle(
                Text.literal("Screen Shake"),
                config.screenShake
            ).setDefaultValue(false)
            .setTooltip(Text.literal("Enable screen shake on high combos"))
            .setSaveConsumer(val -> config.screenShake = val)
            .build());
            
            // Audio Category
            ConfigCategory audio = builder.getOrCreateCategory(Text.literal("Audio"));
            
            audio.addEntry(entryBuilder.startBooleanToggle(
                Text.literal("Enable Sounds"),
                config.soundEnabled
            ).setDefaultValue(true)
            .setSaveConsumer(val -> config.soundEnabled = val)
            .build());
            
            audio.addEntry(entryBuilder.startFloatField(
                Text.literal("Sound Volume"),
                config.soundVolume
            ).setDefaultValue(0.5f)
            .setMin(0.0f)
            .setMax(1.0f)
            .setSaveConsumer(val -> config.soundVolume = val)
            .build());
            
            audio.addEntry(entryBuilder.startBooleanToggle(
                Text.literal("Enable Music"),
                config.musicEnabled
            ).setDefaultValue(false)
            .setTooltip(Text.literal("Play music stings on high combos"))
            .setSaveConsumer(val -> config.musicEnabled = val)
            .build());
            
            // Presets Category
            ConfigCategory presets = builder.getOrCreateCategory(Text.literal("Presets"));
            
            presets.addEntry(entryBuilder.startEnumSelector(
                Text.literal("Active Preset"),
                ComboConfig.ConfigPreset.class,
                config.preset
            ).setDefaultValue(ComboConfig.ConfigPreset.ARCADE)
            .setTooltip(Text.literal("Quick configuration presets"))
            .setSaveConsumer(val -> config.applyPreset(val))
            .build());
            
            builder.setSavingRunnable(config::save);
            
            return builder.build();
        };
    }
}