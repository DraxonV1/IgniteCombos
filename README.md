# 🔥 Ignite Combos

**Arcade-style PvP combo feedback for modern Minecraft combat.**

## Features

### ✨ Core Features

- **Combo Counter System**: Track consecutive hits with arcade-style counting (X1, X2, X3...)
- **Combo Grades**: Earn ranks based on your performance
  - **GOOD** (X5+) - Green
  - **PERFECT** (X10+) - Yellow
  - **AWESOME** (X20+) - Red
  - **GODLIKE** (X30+) - Purple/Neon
- **Smooth Animations**: Scale pops, fades, and optional screen shake
- **Audio Feedback**: Hit sounds with increasing pitch, grade upgrade sounds, combo lost sounds
- **Fully Configurable**: Extensive config via Mod Menu + Cloth Config

### 🎮 Design Philosophy

This mod is designed for **competitive PvP players** who want to:
- Track their combo consistency
- Get instant feedback on attack timing
- Improve their combat skills
- Feel the rush of arcade-style combat

**This is NOT a cheat mod** - it provides only visual/audio feedback that helps players understand their performance.

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.21.5+
2. Download [Fabric API](https://modrinth.com/mod/fabric-api)
3. Download Ignite Combos
4. Place all mods in your `.minecraft/mods` folder
5. Launch Minecraft with the Fabric profile

### Optional Dependencies

- **[Mod Menu](https://modrinth.com/mod/modmenu)** - Access the configuration screen
- **[Cloth Config](https://modrinth.com/mod/cloth-config)** - Included automatically

## Configuration

Access the config via **Mod Menu** → **Ignite Combos** → **Config**

### Settings Categories

#### General
- **Enable Combo System**: Master toggle
- **Reset on Damage**: Reset combo when you take damage
- **Combo Timeout**: Time window between hits (300-2000ms)

#### Visual
- **UI Scale**: Size of the combo display (0.5x - 2.0x)
- **Glow Intensity**: Strength of the glow effect (0.0 - 1.0)
- **Screen Shake**: Enable screen shake on high combos

#### Audio
- **Enable Sounds**: Toggle hit/grade sounds
- **Sound Volume**: Master volume for combo sounds (0.0 - 1.0)
- **Enable Music**: Enable music stings on high combos

#### Presets
- **Minimal**: Subtle, performance-focused
- **Arcade**: Balanced, recommended default
- **Competitive**: Maximum feedback, all effects enabled

## How It Works

### Valid Combo Hits
- Attack cooldown must be ≥95% (fully charged attacks)
- Must hit the same target consecutively
- Hits must be within the timeout window (default 700ms)
- Shield-blocked hits don't count

### Combo Resets When:
- You miss a hit
- You hit too late (beyond timeout)
- You switch targets
- You take damage (if enabled in config)

## Building from Source

```bash
git clone https://github.com/DraxonV1/IgniteCombos.git
cd IgniteCombos
./gradlew build
```

The compiled mod will be in `build/libs/`

## Development

### Project Structure
```
src/main/java/asia/draxon/ignitecombos/
├── IgniteCombos.java          # Main entry point
├── combo/
│   ├── ComboTracker.java      # Core combo logic
│   └── ComboGrade.java        # Grade/tier system
├── render/
│   └── ComboRenderer.java     # HUD rendering
├── sound/
│   └── ComboSoundManager.java # Audio system
├── config/
│   ├── ComboConfig.java       # Configuration logic
│   └── ModMenuIntegration.java # Config GUI
└── mixin/
    ├── PlayerAttackMixin.java # Attack detection
    ├── PlayerDamageMixin.java # Damage detection
    ├── HudRenderMixin.java    # Render hook
    └── ClientTickMixin.java   # Tick handler
```

## Compatibility

- **Minecraft**: 1.21.5+
- **Fabric Loader**: 0.16.10+
- **Fabric API**: 0.128.2+
- **Environment**: Client-only

## License

MIT License - See [LICENSE](LICENSE) file for details

## Credits

**Author**: DraxonV1  
**Website**: https://ignitecombos.mc.draxon.asia  
**Source**: https://github.com/DraxonV1/IgniteCombos

## Support

- **Issues**: [GitHub Issues](https://github.com/DraxonV1/IgniteCombos/issues)
- **Discord**: Join our community server (link coming soon)

---

**Made with 🔥 for the PvP community**