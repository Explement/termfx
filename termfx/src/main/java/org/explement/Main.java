package org.explement;


import org.explement.components.FocusManager;
import org.explement.components.Label;
import org.explement.input.InputManager;
import org.explement.input.Key;
import org.explement.renderer.Cell;
import org.explement.renderer.Renderer;
import org.explement.renderer.ScreenBuffer;

public class Main {
    public static void main(String[] args) {
        /* 
        
        Label = new Label("something");
        Renderer renderer = new Renderer();

        renderer.mainLoop(); 
        
        
        ! END GOAL

        */

        InputManager.isKeyPressed(Key.A); // * Handles ComponentManager initialization aswell, temporary
        FocusManager.initialize();

        ScreenBuffer screenBuffer = new ScreenBuffer(new Vector2(80, 10));
        Renderer renderer = new Renderer(screenBuffer);

        Label label = new Label("Hello, world!", new Vector2(2, 2), new Vector2(40, 3), screenBuffer);

        renderer.mainLoop();
    }
}