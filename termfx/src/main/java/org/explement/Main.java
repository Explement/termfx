package org.explement;


import org.explement.components.Button;
import org.explement.components.FocusManager;
import org.explement.components.Label;
import org.explement.components.PasswordField;
import org.explement.components.TextField;
import org.explement.input.InputManager;
import org.explement.input.Key;
import org.explement.renderer.Cell;
import org.explement.renderer.Renderer;
import org.explement.renderer.ScreenBuffer;
import org.explement.utils.CursorUtils;

public class Main {
    public static void main(String[] args) {

        InputManager.isKeyPressed(Key.A); // * Handles ComponentManager initialization aswell, temporary
        FocusManager.initialize();
        CursorUtils.hide();

        Renderer renderer = new Renderer();

        Button button = new Button("Click me!", new Vector2(2, 1), new Vector2(40, 1), renderer.getScreenBuffer());
        button.setOnAction(() -> {
            button.setText("Hello World!");
        });
        button.setBorder(true);

        Label label = new Label("Label", new Vector2(2, 4), new Vector2(40, 1), renderer.getScreenBuffer());
        PasswordField passwordField = new PasswordField("Password Field", new Vector2(2, 7), new Vector2(40, 1), renderer.getScreenBuffer());
        passwordField.setBorder(true);

        renderer.mainLoop();
    }
}