package org.explement;

public class ScreenBuffer {
    private Cell[][] cells;
    private int x;
    private int y;

    public ScreenBuffer(int x, int y) {
        this.x = x;
        this.y = y;
        cells = new Cell[y][x];
        clearCells();
    }
    
    public void setCell(Cell cell, int x, int y) {
        cells[y][x] = cell;
    }

    public Cell getCell(int x, int y) {
        if (x >= this.x || y >= this.y || y < 0 || x < 0) {
            throw new IndexOutOfBoundsException("(" + x + ", " + y + ") is out of bounds for ScreenBuffer of size (" + this.x + ", " + this.y + ")" );
        }
        return cells[y][x];
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void clearCell(int x, int y) {
        cells[y][x] = new Cell();
    }

    public void clearCells() {
        for (int y = 0; y < this.y; y++) {

            for (int x = 0; x < this.x; x++) {
                clearCell(x, y);
            }

        }
    }
    

}
