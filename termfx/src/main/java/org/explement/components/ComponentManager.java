package org.explement.components;

import java.util.ArrayList;
import java.util.List;

import org.explement.input.Key;

public class ComponentManager {
    private ComponentManager() {}

    private static List<Component> components;

    static {
        components = new ArrayList<>();
    }

    public static List<Component> getComponents() {
        return components;
    }

    public static void removeComponent(Component component) {
        components.remove(component);
    }

    public static void addComponent(Component component) {
        components.add(component);
        FocusManager.initialize(); // TODO: Temporary, currently resets every time a component is added
    }

    public static void handleInput(Key key) {
        switch (key) {
            case TAB:
                FocusManager.next();
                break;
            case ENTER:
                Component focusedComponent = FocusManager.getFocusedComponent();
                if (focusedComponent != null) {
                    focusedComponent.onAction();
                }
                break;
        }
    }
}
                                