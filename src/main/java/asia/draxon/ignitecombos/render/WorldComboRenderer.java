package asia.draxon.ignitecombos.render;

import asia.draxon.ignitecombos.combo.ComboTracker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class WorldComboRenderer {

    public static void render(DrawContext ctx) {
        ComboTracker tracker = ComboTracker.getInstance();
        if (!tracker.isActive()) return;

        Entity target = tracker.getLastTarget();
        if (target == null) return;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.gameRenderer == null || client.player == null) return;

        // Use current position (no tickDelta in 1.21.5)
        Vec3d pos = target.getPos()
                .add(0, target.getHeight() + 0.5, 0);

        Vec3d cam = client.gameRenderer.getCamera().getPos();
        Vec3d relative = pos.subtract(cam);

        double dist = cam.distanceTo(pos);
        float scale = (float) Math.max(0.02, 0.04 / dist);

        ctx.getMatrices().push();

        ctx.getMatrices().translate(
                relative.x,
                relative.y,
                relative.z
        );

        ctx.getMatrices().multiply(
                client.gameRenderer.getCamera().getRotation()
        );

        ctx.getMatrices().scale(-scale, -scale, scale);

        String text = "x" + tracker.getCombo();
        int width = client.textRenderer.getWidth(text);

        ctx.drawText(
                client.textRenderer,
                text,
                -width / 2,
                0,
                0xFFFFFF,
                true
        );

        ctx.getMatrices().pop();
    }
}
