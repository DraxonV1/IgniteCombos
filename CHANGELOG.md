# Changelog

All notable changes to Ignite Combos will be documented in this file.

## [1.0.0] - 2025-01-03

### Added
- Initial release of Ignite Combos
- Arcade-style combo counter system with consecutive hit tracking
- Combo grade system with 5 tiers (GOOD, PERFECT, AWESOME, GODLIKE)
- Smooth animations with scale pops and fade effects
- Audio feedback system with pitch-shifting hit sounds
- Grade upgrade sounds for tier progression
- Combo lost sound effects
- Full Cloth Config integration with Mod Menu support
- Configuration presets (Minimal, Arcade, Competitive)
- Configurable combo timeout (300-2000ms)
- Adjustable UI scale (0.5x - 2.0x)
- Glow effects with intensity control
- Optional screen shake for high combos
- Reset on damage toggle
- Client-side only implementation (no server-side requirements)

### Features
- **Combat Tracking**: Tracks attack cooldown, target consistency, and hit timing
- **Visual Feedback**: Dynamic color system based on combo tier
- **Audio System**: Contextual sounds for hits, grades, and combo loss
- **Performance**: Optimized time-based animations (no tick dependencies)
- **Configuration**: Extensive customization via Mod Menu

### Technical
- Built for Minecraft 1.21.5+
- Fabric Loader 0.16.10+
- Fabric API 0.128.2+
- Java 21+
- Client environment only
- Mixin-based implementation for clean compatibility

---

## Future Plans

### Version 1.1.0 (Planned)
- Custom texture-based font system
- Bitmap font atlas support
- Enhanced glow shaders
- Music sting system for high combos
- Position customization (HUD vs world-space)
- Additional animation styles

### Version 1.2.0 (Planned)
- Combo statistics tracking
- Personal best records
- Session statistics
- Export/share combo achievements

### Version 2.0.0 (Long-term)
- Advanced visual effects system
- Custom particle effects
- Combo trail rendering
- Team combo support
- Tournament mode

---

## Versioning

This project follows [Semantic Versioning](https://semver.org/):
- **MAJOR**: Breaking changes or significant rewrites
- **MINOR**: New features, backwards compatible
- **PATCH**: Bug fixes and minor improvements