package org.explement.components;

import org.explement.input.Key;

public interface Component {
    public default void registerComponent() {
        ComponentManager.addComponent(this);
    }
    public void renderToBuffer();
    public default void onAction() {};
    public default void onKeyPress(Key key) {};

    

}
