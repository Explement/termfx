package org.explement;

import org.explement.components.Label;
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


        ScreenBuffer screenBuffer = new ScreenBuffer(new Vector2(80, 10));
        Renderer renderer = new Renderer(screenBuffer);

        Label label = new Label("Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!", new Vector2(2, 2));
        label.renderToBuffer(renderer.getScreenBuffer());

        renderer.render();
    }
}