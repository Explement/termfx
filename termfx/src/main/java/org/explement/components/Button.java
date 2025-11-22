package org.explement.components;

import org.explement.Vector2;
import org.explement.renderer.Cell;
import org.explement.renderer.ScreenBuffer;
import org.explement.utils.UnicodeUtils;

public class Button extends Label {

    private Runnable onActionRunnable;
    
    public Button(String text, Vector2 position, Vector2 size, ScreenBuffer screenBuffer) {
        super(text, position, size, screenBuffer);
    }

    public Button(Vector2 position, Vector2 size, ScreenBuffer screenBuffer) {
        super(position, size, screenBuffer);
    }

    public void setOnAction(Runnable runnable) {
        this.onActionRunnable = runnable;
    }  
    
    @Override
    public void onAction() {
        if (onActionRunnable != null) {
            onActionRunnable.run();
        }
    }

   
}
