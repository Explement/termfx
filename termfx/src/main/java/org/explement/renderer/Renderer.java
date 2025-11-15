package org.explement.renderer;

import java.util.HashSet;
import java.util.Set;

import org.explement.Vector2;
import org.explement.utils.CursorUtils;
import org.explement.utils.TerminalUtils;

public class Renderer {
    private final ScreenBuffer screenBuffer;
    private final ScreenBuffer previousScreenBuffer;

    public Renderer(ScreenBuffer screenBuffer) {
        this.screenBuffer = screenBuffer;
        this.previousScreenBuffer = new ScreenBuffer(screenBuffer.getSize());
        initialize();
    }
    public Renderer() {
        this.screenBuffer = new ScreenBuffer(new Vector2(30, 30));
        this.previousScreenBuffer = new ScreenBuffer(new Vector2(30, 30));
        initialize();
    }

    public void initialize() {
        TerminalUtils.clear();
    }
    public void render() {
        Set<Vector2> dirtyCells = screenBuffer.getDirtyCells();
        if (dirtyCells.isEmpty()) return;
        
        for (Vector2 position : new HashSet<>(dirtyCells)) {
            Cell current = screenBuffer.getCell(position);
            Cell previous = previousScreenBuffer.getCell(position);
            
            if (!current.equals(previous)) {
                TerminalUtils.printAt(current.getCharacter(), position);
                previousScreenBuffer.setCell(current, position.getX(), position.getY());
            }
        }
        
        screenBuffer.clearDirty();
        CursorUtils.moveTo(new Vector2(0, screenBuffer.getY() + 1));
    }

    public ScreenBuffer getScreenBuffer() {
        return screenBuffer;
    }
}
