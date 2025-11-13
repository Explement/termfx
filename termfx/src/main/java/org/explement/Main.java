package org.explement;

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

        Cell cell = new Cell('H');
        Cell cell1 = new Cell('E');
        Cell cell2 = new Cell('L');
        Cell cell3 = new Cell('L');
        Cell cell4 = new Cell('O');
        

        int x = 0;
        int y = 0;
        for (Cell c : new Cell[] {cell, cell1, cell2, cell3, cell4}) {
            screenBuffer.setCell(c, x, y);
            x++;
            y++;
        }

        renderer.render();
    }
}