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
        //renderText(screenBuffer);
    }

    private void renderBorder(ScreenBuffer screenBuffer) {
        int maxWidth = (screenBuffer.getX() - x) - 1;

        int drawX = x;
        int drawY = y;

        // ! Replace printing via Terminal Utils TODO
        screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_TOP_LEFT), drawX, drawY);
        for (int i = 0; i < maxWidth; i++) {
            drawX++;
            screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_HORIZONTAL), drawX, drawY);
        }

        screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_TOP_RIGHT), drawX, drawY);
        
        drawX = x;
        drawY = y;

        int lines = Math.ceilDiv(text.length(), maxWidth);

        for (int i = 0; i < lines; i++) {
            drawY++;
            screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_VERTICAL), drawX, drawY);
        }

        screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_BOTTOM_LEFT), drawX, drawY);
        for (int i = 0; i < maxWidth; i++) {
            drawX++;
            screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_HORIZONTAL), drawX, drawY);
        }
        drawX = x + maxWidth;
        drawY = y;

        for (int i = 0; i < lines; i++) {
            drawY++;
            screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_VERTICAL), drawX, drawY);
        }
        screenBuffer.setCell(new Cell(UnicodeUtils.BORDER_BOTTOM_RIGHT), drawX, drawY);

    }

    private void renderText(ScreenBuffer screenBuffer) {
        int drawX = x;
        int drawY = y;

        for (char c : text.toCharArray()) {
            if (drawX >= screenBuffer.getX()) {
                drawX = x;
                drawY++;
            }
            if (drawY >= screenBuffer.getY()) return;

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
