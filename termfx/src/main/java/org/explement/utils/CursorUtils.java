package org.explement.utils;

import org.explement.Vector2;

public class CursorUtils {
    private CursorUtils() {}

    private static Vector2 position = new Vector2(0, 0);

    public static void show() {
        System.out.print("\u001B[?25h");
    }

    public static void hide() {
        System.out.print("\u001B[?25l");
    }

    public static void moveTo(Vector2 position) {
        System.out.printf("\u001B[%d;%dH", position.getY(), position.getX());
        System.out.flush();
        setPosition(position);
    }

    public static Vector2 getPosition() {
        return position;
    }

    public static void setPosition(Vector2 position) {
        CursorUtils.position = position;
    }
}
