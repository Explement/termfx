package org.explement.input;

import java.util.HashMap;

import com.sun.jna.Native;
import com.sun.jna.Library;

import org.explement.components.ComponentManager;

public class InputManager {
    private InputManager() {}

    private static HashMap<Key, Boolean> keyStates;
    private final static User32 user32;

    static {
        keyStates = new HashMap<>();
        user32 = User32.INSTANCE;
        initializeKeyStates();
        createInputThread();
    }

    public static boolean isKeyPressed(Key key) {
        return (user32.GetAsyncKeyState(key.keyCode()) & 0x8000) != 0;
    }

    public static void update() {
        for (Key key : keyStates.keySet()) {
            boolean pressed = isKeyPressed(key);
            boolean wasPressed = keyStates.get(key);

            if (pressed && !wasPressed) {
                ComponentManager.handleInput(key);
            }

            keyStates.put(key, pressed);
        }
    }

    public interface User32 extends Library {
        User32 INSTANCE = Native.load("user32", User32.class);
        short GetAsyncKeyState(int vKey);
    }

    private static void createInputThread() {

        Thread inputThread = new Thread(() -> {
            while (true) {
                update();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        inputThread.setDaemon(true); 
        inputThread.start();
    }

    private static void initializeKeyStates() {
        for (Key key : Key.values()) {
            keyStates.put(key, false);
        }
    }
}
