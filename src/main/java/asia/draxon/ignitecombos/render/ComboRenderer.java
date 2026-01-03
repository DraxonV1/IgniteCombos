package asia.draxon.ignitecombos.render;

import asia.draxon.ignitecombos.combo.ComboTracker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class ComboRenderer {

    public void render(DrawContext ctx) {
        ComboTracker tracker = ComboTracker.getInstance();
        if (!tracker.isActive()) return;

        MinecraftClient client = MinecraftClient.getInstance();

        String text = "x" + tracker.getCombo();
        int x = client.getWindow().getScaledWidth() - 40;
        int y = client.getWindow().getScaledHeight() / 2;

        ctx.drawText(
                client.textRenderer,
                text,
                x,
                y,
                0xFFAA00,
                true
        );
    }
}
