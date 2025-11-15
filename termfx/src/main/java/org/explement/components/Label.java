package org.explement.components;

import org.explement.renderer.Cell;
import org.explement.renderer.ScreenBuffer;
import org.explement.utils.UnicodeUtils;

public class Label implements Component {
    private String text;
    private boolean hasBorder = true;
    // * Positions
    private int x;
    private int y;

    public Label(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Label(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    @Override
    public void renderToBuffer(ScreenBuffer screenBuffer) {
        if (hasBorder) renderBorder(screenBuffer);
        renderText(screenBuffer);
    }

    private void renderBorder(ScreenBuffer screenBuffer) {
        int innerWidth = screenBuffer.getX() - x - 2; // Exclude borders

        // ! Replace printing via Terminal Utils TODO
        screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_TOP_LEFT), x, y);
        for (int i = 1; i <= innerWidth; i++) {
            screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_HORIZONTAL), x + i, y);
        }
        screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_TOP_RIGHT), x + innerWidth + 1, y);

        

        int lines = Math.ceilDiv(text.length(), innerWidth);

        for (int i = 1; i <= lines; i++) {
            screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_VERTICAL), x, y + i);
            screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_VERTICAL), x + innerWidth + 1, y + i);
        }


        screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_BOTTOM_LEFT), x, y + lines + 1);
        for (int i = 1; i <= innerWidth; i++) {
            screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_HORIZONTAL), x + i, y + lines + 1);
        }
        screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_BOTTOM_RIGHT), x + innerWidth + 1, y + lines + 1);

    }

    private void renderText(ScreenBuffer screenBuffer) {
        int drawX = x + 1; // Start inside left border
        int drawY = y + 1; // Start inside top border
        int innerWidth = screenBuffer.getX() - x - 2;

        for (char c : text.toCharArray()) {
            if (drawX > x + innerWidth) {
                drawX = x + 1;
                drawY++;
            }
            
            if (drawY >= screenBuffer.getY() - 1) return;

            screenBuffer.setCell(new Cell(c), drawX, drawY);
            drawX++;
        }
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
     
    public boolean hasBorder() {
        return hasBorder;
    }

    public void setBorder(boolean hasBorder) {
        this.hasBorder = hasBorder;
    }
}
