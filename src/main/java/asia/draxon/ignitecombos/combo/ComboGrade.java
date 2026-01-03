package asia.draxon.ignitecombos.combo;

public enum ComboGrade {
    NONE("", 0xFFFFFF, 0),
    GOOD("GOOD", 0x00FF00, 5),
    PERFECT("PERFECT", 0xFFFF00, 10),
    AWESOME("AWESOME", 0xFF0000, 20),
    GODLIKE("GODLIKE", 0xFF00FF, 30);
    
    private final String displayName;
    private final int color;
    private final int threshold;
    
    ComboGrade(String displayName, int color, int threshold) {
        this.displayName = displayName;
        this.color = color;
        this.threshold = threshold;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public int getColor() {
        return color;
    }
    
    public int getThreshold() {
        return threshold;
    }
    
    public static ComboGrade fromCombo(int combo) {
        if (combo >= GODLIKE.threshold) return GODLIKE;
        if (combo >= AWESOME.threshold) return AWESOME;
        if (combo >= PERFECT.threshold) return PERFECT;
        if (combo >= GOOD.threshold) return GOOD;
        return NONE;
    }
    
    public float getGlowIntensity() {
        return switch (this) {
            case GODLIKE -> 1.0f;
            case AWESOME -> 0.8f;
            case PERFECT -> 0.6f;
            case GOOD -> 0.4f;
            default -> 0.0f;
        };
    }
}