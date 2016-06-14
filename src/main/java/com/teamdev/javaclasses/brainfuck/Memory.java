package com.teamdev.javaclasses.brainfuck;

import java.util.Arrays;

public class Memory {

    private int[] cells;
    private int pointer;

    public Memory(int size) {
        this.cells = new int[size];
    }

    public int getPointer() {
        return pointer;
    }

    public int getCurrentCellValue() {
        return cells[pointer];
    }

    public void incrementCellValue(int size) {
        cells[pointer] += size;
    }

    public void decrementCellValue(int size) {
        cells[pointer] -= size;
    }

    public void movePointerToRight(int steps) {
        if (pointer + steps >= cells.length) {
            ensureCapacity();
        }
        pointer += steps;
    }

    public void movePointerToLeft(int steps) {
        if (pointer - steps < 0) {
            throw new ArrayIndexOutOfBoundsException("Pointer exits outside the array");
        }
        pointer -= steps;
    }

    private void ensureCapacity() {
        int newSize = cells.length * 2;
        cells = Arrays.copyOf(cells, newSize);
    }
}
