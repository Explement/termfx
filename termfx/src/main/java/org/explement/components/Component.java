package org.explement.components;

import org.explement.renderer.ScreenBuffer;

public interface Component {
    public void renderToBuffer(ScreenBuffer screenBuffer);
}
