package org.explement.components;

import org.explement.renderer.ScreenBuffer;

public interface Component {
    public default void registerComponent() {
        ComponentManager.addComponent(this);
    }
    public void renderToBuffer();
    public void onAction();
    /* 
     * 
     * 
     * TO DO TOMMOROW
     * 
     * START WORKING ON INPUT HANDLING
     * ADD KEY PRESS EVENTS 
     * ADD SEPERATE INPUT THREAD
     */
}
