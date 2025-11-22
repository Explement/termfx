package org.explement.components;

import org.explement.Vector2;
import org.explement.input.Key;
import org.explement.renderer.ScreenBuffer;
import org.explement.utils.CursorUtils;

public class TextField extends Label {
    private boolean active = false;

    public TextField(String text, Vector2 position, Vector2 size, ScreenBuffer screenBuffer) {
        super(text, position, size, screenBuffer);
    }

    public TextField(Vector2 position, Vector2 size, ScreenBuffer screenBuffer) {
        super(position, size, screenBuffer);
    }

    @Override
    public void onAction() {
        active = true;
        CursorUtils.show();

        int positionX = position.getX() + getText().length() + 1;
        int positionY = position.getY() + 1;
        CursorUtils.moveTo(new Vector2(positionX, positionY));

    }

    public void onKeyPress(Key key) {
        switch (key) {
            case TAB:
                if (active) {
                    text += "\t";
                } else {
                    CursorUtils.hide();
                }
                break;
            case ESCAPE:
                active = false;
                break;
            case SPACE:
                if (active) {
                    setText(text + " ");
                }
                break;
            case BACKSPACE:
                if (active) {
                    if (text != null && text.length() > 0) {
                        setText(text.substring(0, text.length() - 1));
                    }
                }
                break;
            case NUM0:
            case NUM1:
            case NUM2:
            case NUM3:
            case NUM4:
            case NUM5:
            case NUM6:
            case NUM7:
            case NUM8:
            case NUM9:
                if (active) {
                    setText(text + key.name().substring(3));
                }
                break;
            default:
                if (active) {
                    setText(text + key.name().toLowerCase());
                }
                break;
        }

        if (active) {
            int positionX = position.getX() + getText().length() + 1;
            int positionY = position.getY() + 1;
            CursorUtils.moveTo(new Vector2(positionX, positionY));
        }
    }


    public boolean getActive() {
        return active;
    }
}
