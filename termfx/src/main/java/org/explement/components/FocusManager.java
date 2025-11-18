package org.explement.components;

import java.util.List;

public class FocusManager {
    private FocusManager() {}

    private static Component focusedComponent;

    public static void initialize() {
        List<Component> components = ComponentManager.getComponents();
        if (components != null && !components.isEmpty()) {
            focusedComponent = components.get(0);
        }
    }
    public static Component getFocusedComponent() {
        return focusedComponent;
    }

    public static void setFocusedComponent(Component component) {
        focusedComponent = component;
    }

    public static Component next() {
        List<Component> components = ComponentManager.getComponents();
        if (components == null || components.isEmpty()) {
            throw new NullPointerException("ComponentManager has no components or is null");
        }

        int index = components.indexOf(focusedComponent);
        index = (index + 1) % components.size();
        focusedComponent = components.get(index);

        return focusedComponent;
    }

}
