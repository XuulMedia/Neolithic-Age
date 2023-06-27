package github.xuulmedia.neolith.util;

import net.minecraft.network.chat.Component;

import java.util.function.Supplier;

public class TooltipHelper {
    private final int xMin;
    private final int xMax;
    private final int yMin;
    private final int yMax;
    private final Supplier<Boolean> condition;
    private final Supplier<Component> text;

    public TooltipHelper(int xMin, int xMax, int yMin, int yMax, Supplier<Boolean> condition, Supplier<Component> text) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.condition = condition;
        this.text = text;
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
        return mouseX >= xMin && mouseX <= xMax && mouseY >= yMin && mouseY <= yMax;
    }

    public boolean shouldRender() {
        return condition.get();
    }

    public Component getText() {
        return text.get();
    }
}
