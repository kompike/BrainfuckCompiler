package com.teamdev.javaclasses.brainfuck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemoryTest {

    private final Memory memory = new Memory(10);

    @Test
    public void testIncrementCellValue() throws Exception {
        assertEquals("Current cell value does not match!", 0, memory.getCurrentCellValue());
        memory.incrementCellValue(3);
        assertEquals("Current cell value does not match!", 3, memory.getCurrentCellValue());
    }

    @Test
    public void testDecrementCellValue() throws Exception {
        assertEquals("Current cell value does not match!", 0, memory.getCurrentCellValue());
        memory.incrementCellValue(3);
        memory.decrementCellValue(2);
        assertEquals("Current cell value does not match!", 1, memory.getCurrentCellValue());
    }

    @Test
    public void testMovePointerToRight() throws Exception {
        assertEquals("Pointer value does not match!", 0, memory.getPointer());
        memory.movePointerToRight(3);
        assertEquals("Pointer value does not match!", 3, memory.getPointer());
    }

    @Test
    public void testMovePointerToLeft() throws Exception {
        assertEquals("Pointer value does not match!", 0, memory.getPointer());
        memory.movePointerToRight(3);
        memory.movePointerToLeft(2);
        assertEquals("Pointer value does not match!", 1, memory.getPointer());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMovePointerException() {
        memory.movePointerToLeft(2);
    }

}