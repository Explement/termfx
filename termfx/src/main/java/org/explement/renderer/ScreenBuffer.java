package org.explement.renderer;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.explement.Vector2;

public class ScreenBuffer {
    private Cell[][] cells;
    private Vector2 size;
    private Set<Vector2> dirtyCells;
    
    public ScreenBuffer(Vector2 size) {
        this.size = size;
        this.dirtyCells = new HashSet<>();
        cells = new Cell[size.getY()][size.getX()];
        clearCells();
    }
    
    public void setCell(Cell cell, int x, int y) {
        cells[y][x] = cell;
        dirtyCells.add(new Vector2(x, y));
    }

    public Cell getCell(int x, int y) {
        return getCell(new Vector2(x, y));
    }

    public Cell getCell(Vector2 position) {
        int x = position.getX();
        int y = position.getY();

        if (x >= this.size.getX() || y >= this.size.getY() || y < 0 || x < 0) {
            throw new IndexOutOfBoundsException("(" + x + ", " + y + ") is out of bounds for ScreenBuffer of size (" + this.getX() + ", " + this.getY() + ")" );
        }
        return cells[y][x];
    }

    public int getX() {
        return size.getX();
    }

    public void setX(int x) {
        this.size = new Vector2(x, this.size.getY());
    }

    public int getY() {
        return size.getY();
    }

    public void setY(int y) {
        this.size = new Vector2(this.size.getX(), y);
    }

    public Vector2 getSize() {
        return size;
    }
    
    public void setSize(Vector2 size) {
        this.size = size;
        cells = new Cell[size.getY()][size.getX()];
        clearCells();
    }

    public void clearCell(int x, int y) {
        cells[y][x] = new Cell();
        dirtyCells.add(new Vector2(x, y));
    }

    public void clearCells() {


        for (int y = 0; y < this.getY(); y++) {

            for (int x = 0; x < this.getX(); x++) {
                clearCell(x, y);
            }

        }
    }
    

    public void setDirty(Vector2 position) {
        dirtyCells.add(position);
    }

    public Set<Vector2> getDirtyCells() {
        return dirtyCells;
    }

    public boolean getDirtyCell(Vector2 position) {
        return dirtyCells.contains(position);
    }
    
    public void clearDirty() {
        dirtyCells.clear();
    }
}
