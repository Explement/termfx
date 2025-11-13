package org.explement;

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



        ScreenBuffer screenBuffer = new ScreenBuffer(40, 10);
        Renderer renderer = new Renderer(screenBuffer);

        Label label = new Label("Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello, Hello", 0, 0);
        label.renderToBuffer(screenBuffer);

        renderer.render();
    }
}