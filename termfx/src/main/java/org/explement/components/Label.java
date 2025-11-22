package org.explement.components;

import org.explement.Vector2;
import org.explement.renderer.Cell;
import org.explement.renderer.ScreenBuffer;
import org.explement.utils.UnicodeUtils;

public class Label implements Component {
    protected ScreenBuffer screenBuffer;
    protected String text;
    protected boolean hasBorder;
    protected Vector2 position;
    protected Vector2 size = new Vector2(20, 5);
    protected Vector2 oldSize;
    
    // TODO: Add sizes
    public Label(Vector2 position, Vector2 size, ScreenBuffer screenBuffer) {
        this.screenBuffer = null;
        this.position = position;
        this.size = size;
        this.screenBuffer = screenBuffer;
        registerComponent();
    }

    public Label(String text, Vector2 position, Vector2 size, ScreenBuffer screenBuffer) {
        this.screenBuffer = null;
        this.text = text;
        this.position = position;
        this.size = size;
        this.screenBuffer = screenBuffer;
        registerComponent();
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
        renderText(screenBuffer, text);

        // TODO: Add copy method to Vector2
        oldSize = new Vector2(size.getX(), size.getY());
    }

    // TODO: Fix label resizing, borders glitch out because of computed size, which leaves previous borders
    protected void renderBorder(ScreenBuffer screenBuffer) {
        boolean isFocused = FocusManager.getFocusedComponent() == this;
        char BORDER_TOP_RIGHT = (isFocused) ? UnicodeUtils.BORDER_DOUBLE_TOP_RIGHT : UnicodeUtils.BORDER_TOP_RIGHT;
        char BORDER_TOP_LEFT = (isFocused) ? UnicodeUtils.BORDER_DOUBLE_TOP_LEFT : UnicodeUtils.BORDER_TOP_LEFT;
        char BORDER_BOTTOM_RIGHT = (isFocused) ? UnicodeUtils.BORDER_DOUBLE_BOTTOM_RIGHT : UnicodeUtils.BORDER_BOTTOM_RIGHT;
        char BORDER_BOTTOM_LEFT = (isFocused) ? UnicodeUtils.BORDER_DOUBLE_BOTTOM_LEFT : UnicodeUtils.BORDER_BOTTOM_LEFT;
        char BORDER_HORIZONTAL = (isFocused) ? UnicodeUtils.BORDER_DOUBLE_HORIZONTAL : UnicodeUtils.BORDER_HORIZONTAL;
        char BORDER_VERTICAL = (isFocused) ? UnicodeUtils.BORDER_DOUBLE_VERTICAL : UnicodeUtils.BORDER_VERTICAL;
        
        int x = position.getX();
        int y = position.getY();

        int innerWidth = size.getX();

        // ! Replace printing via Terminal Utils TODO
        screenBuffer.setCell(new Cell(BORDER_TOP_LEFT), x, y);
        for (int i = 1; i <= innerWidth; i++) {
            screenBuffer.setCell(new Cell(BORDER_HORIZONTAL), x + i, y);
        }
        screenBuffer.setCell(new Cell(BORDER_TOP_RIGHT), x + innerWidth + 1, y);

        int lines = size.getY();

        for (int i = 1; i <= lines; i++) {
            screenBuffer.setCell(new Cell(BORDER_VERTICAL), x, y + i);
            screenBuffer.setCell(new Cell(BORDER_VERTICAL), x + innerWidth + 1, y + i);
        }


        screenBuffer.setCell(new Cell(BORDER_BOTTOM_LEFT), x, y + lines + 1);
        for (int i = 1; i <= innerWidth; i++) {
            screenBuffer.setCell(new Cell(BORDER_HORIZONTAL), x + i, y + lines + 1);
        }
        screenBuffer.setCell(new Cell(BORDER_BOTTOM_RIGHT), x + innerWidth + 1, y + lines + 1);

    }

    protected void renderText(ScreenBuffer screenBuffer, String text) {
        int x = position.getX();
        int y = position.getY();

        int drawX = x + 1; // Start inside left border
        int drawY = y + 1; // Start inside top border

        int innerWidth = size.getX();
        int lines = size.getY();

        for (char c : text.toCharArray()) {
            if (drawX > x + innerWidth) {
                drawX = x + 1;
                drawY++;
            }
            
            if (drawY > y + lines) return;

            screenBuffer.setCell(new Cell(c), drawX, drawY);
            drawX++;
        }
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        renderToBuffer();
    }
     
    public boolean hasBorder() {
        return hasBorder;
    }

    public void setBorder(boolean hasBorder) {
        this.hasBorder = hasBorder;
        renderToBuffer();
    }
    
    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
        renderToBuffer();
    }


}
