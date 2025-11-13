package org.explement;

import org.explement.renderer.Cell;
import org.explement.renderer.ScreenBuffer;

public class Label implements Component {
    private String text;
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
     
}
