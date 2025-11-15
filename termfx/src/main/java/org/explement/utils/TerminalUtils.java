package org.explement.utils;

import org.explement.Vector2;

public class TerminalUtils {
    private TerminalUtils() {}

    public static void printAt(String text, Vector2 position) {
        Vector2 previousPosition = CursorUtils.getPosition();
        CursorUtils.moveTo(position);
        System.out.print(text);
        CursorUtils.moveTo(previousPosition);
    }
    
    public static void printAt(char character, Vector2 position) {
        Vector2 previousPosition = CursorUtils.getPosition();
        CursorUtils.moveTo(position);
        System.out.print(character);
        CursorUtils.moveTo(previousPosition);
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
