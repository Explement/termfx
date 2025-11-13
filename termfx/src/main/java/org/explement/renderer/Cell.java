package org.explement.renderer;

public class Cell {
    private char character;

    public Cell() {
        this(' ');
    }

    public Cell(char character) {
        this.character = character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
