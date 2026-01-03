package asia.draxon.ignitecombos.combo;

import asia.draxon.ignitecombos.IgniteCombos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class ComboTracker {

    private static final ComboTracker INSTANCE = new ComboTracker();

    public static ComboTracker getInstance() {
        return INSTANCE;
    }

    private int combo = 0;
    private Entity lastTarget;
    private long lastCombatTime;

    public void onHit(PlayerEntity player, Entity target) {
        long now = System.currentTimeMillis();

        if (lastTarget != target) {
            combo = 0;
        }

        combo++;
        lastTarget = target;
        lastCombatTime = now;
    }

    public void onDamaged() {
        reset();
    }

    public void tick() {
        if (combo > 0 && System.currentTimeMillis() - lastCombatTime > IgniteCombos.getConfig().comboTimeout) {
            reset();
        }
    }

    private void reset() {
        combo = 0;
        lastTarget = null;
    }

    public int getCombo() {
        return combo;
    }

    public boolean isActive() {
        return combo > 0;
    }

    public Entity getLastTarget() {
        return lastTarget;
    }
}
