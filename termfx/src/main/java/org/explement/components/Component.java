package org.explement;

import org.explement.renderer.ScreenBuffer;

public interface Component {
    public void renderToBuffer(ScreenBuffer screenBuffer);
}
