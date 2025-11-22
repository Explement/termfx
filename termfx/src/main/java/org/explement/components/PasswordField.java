package org.explement.components;

import org.explement.Vector2;
import org.explement.renderer.ScreenBuffer;

public class PasswordField extends TextField {
    private boolean hidden;

    public PasswordField(String text, Vector2 position, Vector2 size, ScreenBuffer screenBuffer) {
        super(text, position, size, screenBuffer);
        this.hidden = true;
    }

    public PasswordField(Vector2 position, Vector2 size, ScreenBuffer screenBuffer) {
        super(position, size, screenBuffer);
        this.hidden = true;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    private String hideText() {
        return "*".repeat(text.length());
    }

    @Override
    public void renderToBuffer() {
                if (position == null) throw new NullPointerException("Label position is null ");
        
        if (oldSize != null) {
            for (int y = position.getY(); y < position.getY() + oldSize.getY() + 2; y++) {
                for (int x = position.getX(); x < position.getX() + oldSize.getX() + 2; x++) {
                    screenBuffer.clearCell(x, y);
                }
            }
        }


        if (hasBorder || FocusManager.getFocusedComponent() == this)  renderBorder(screenBuffer);

        renderText(screenBuffer, (hidden) ? hideText() : text);

        // TODO: Add copy method to Vector2
        oldSize = new Vector2(size.getX(), size.getY());
    }
    
}
