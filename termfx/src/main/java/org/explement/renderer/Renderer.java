package org.explement;

public class Renderer {
    private final ScreenBuffer screenBuffer;

    public Renderer(ScreenBuffer screenBuffer) {
        this.screenBuffer = screenBuffer;
    }

    public void render() {
        for (int y = 0; y < screenBuffer.getY(); y++) {
            for (int x = 0; x < screenBuffer.getX(); x++) {
                // Warning: Make a class to print instead of doing here directly
                System.out.print(
                    screenBuffer.getCell(x, y)
                    .getCharacter()
                );
            }
            // New line
            System.out.println();
        }
    }
}
