package org.mspadaru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightGridTest {

    @Test
    void test1x1GridTurnLightsOn() {
        LightGrid lightGrid = new LightGrid(1, 1);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(0, 0));
        assertEquals(1, lightGrid.countLightsOn());
    }

    @Test
    void test1x1GridTurnLightsOff() {
        LightGrid lightGrid = new LightGrid(1, 1);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(0, 0));
        lightGrid.turnLightsOff(new Point(0, 0), new Point(0, 0));
        assertEquals(0, lightGrid.countLightsOn());
    }

    @Test
    void test10x10GridTurnLightsOn() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(9, 9));
        assertEquals(100, lightGrid.countLightsOn());
    }

    @Test
    void test10x10GridTurnLightsOff() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(9, 9));
        lightGrid.turnLightsOff(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.countLightsOn());
    }

    @Test
    void test10x10GridTurnLightsOnPartial() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnLightsOn(new Point(2, 2), new Point(8, 8));
        assertEquals(49, lightGrid.countLightsOn());
    }

    @Test
    void test10x10GridTurnLightsOffPartial() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(9, 9));
        lightGrid.turnLightsOff(new Point(2, 2), new Point(8, 8));
        assertEquals(51, lightGrid.countLightsOn());
    }

    @Test
    void test10x10GridTurnLightsOnCorners() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(0, 0));
        lightGrid.turnLightsOn(new Point(0, 9), new Point(0, 9));
        lightGrid.turnLightsOn(new Point(9, 0), new Point(9, 0));
        lightGrid.turnLightsOn(new Point(9, 9), new Point(9, 9));
        assertEquals(4, lightGrid.countLightsOn());
    }

    @Test
    void test10x10GridTurnLightsOffCorners() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(9, 9));
        lightGrid.turnLightsOff(new Point(0, 0), new Point(0, 0));
        lightGrid.turnLightsOff(new Point(0, 9), new Point(0, 9));
        lightGrid.turnLightsOff(new Point(9, 0), new Point(9, 0));
        lightGrid.turnLightsOff(new Point(9, 9), new Point(9, 9));
        assertEquals(96, lightGrid.countLightsOn());
    }

    @Test
    void test10x10GridTurnLightsOnPartialNoChangeIfWasAlreadyOn() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnLightsOn(new Point(2, 2), new Point(8, 8));
        lightGrid.turnLightsOn(new Point(2, 2), new Point(8, 8));
        assertEquals(49, lightGrid.countLightsOn());
    }


    @Test
    void test10x10GridTurnLightsOffPartialNoChangeIfWasAlreadyOff() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(9, 9));
        lightGrid.turnLightsOff(new Point(2, 2), new Point(8, 8));
        lightGrid.turnLightsOff(new Point(2, 2), new Point(8, 8));
        assertEquals(51, lightGrid.countLightsOn());
    }

}