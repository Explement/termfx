package org.explement.renderer;

public class Renderer {
    private final ScreenBuffer screenBuffer;

    public Renderer() { // Make utils class to get windows terminal size
        screenBuffer = new ScreenBuffer(30, 30);
    }

    public Renderer(ScreenBuffer screenBuffer) {
        this.screenBuffer = screenBuffer;
    }

    public void render() {
        for (int y = 0; y < screenBuffer.getY(); y++) {
            for (int x = 0; x < screenBuffer.getX(); x++) {
                // ! Warning: Make a class to print instead of doing here directly
                // ! Warning: Fix O(m*n) -> O(m) by just using dirty cell tracking
                System.out.print(
                    screenBuffer.getCell(x, y)
                    .getCharacter()
                );
            }
            // New line
            System.out.println();
        }
    }

    public ScreenBuffer getScreenBuffer() {
        return screenBuffer;
    }
}
