package org.mspadaru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LightGridTest {

    @Test
    void test1X1GridTurnOnLights() {
        LightGrid lightGrid = new LightGrid(1, 1);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        assertEquals(1, lightGrid.countLightsOn());
    }

    @Test
    void test1X1GridTurnOffLights() {
        LightGrid lightGrid = new LightGrid(1, 1);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOffLights(new Point(0, 0), new Point(0, 0));
        assertEquals(0, lightGrid.countLightsOn());
    }

    @Test
    void test10X10GridTurnOnLights() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        assertEquals(100, lightGrid.countLightsOn());
    }

    @Test
    void test10X10GridTurnOffLights() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.countLightsOn());
    }

    @Test
    void test10X10GridTurnOnLightsPartial() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnOnLights(new Point(2, 2), new Point(8, 8));
        assertEquals(49, lightGrid.countLightsOn());
    }

    @Test
    void test10X10GridTurnOffLightsPartial() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(2, 2), new Point(8, 8));
        assertEquals(51, lightGrid.countLightsOn());
    }

    @Test
    void test10X10GridTurnOnLightsCorners() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOnLights(new Point(0, 9), new Point(0, 9));
        lightGrid.turnOnLights(new Point(9, 0), new Point(9, 0));
        lightGrid.turnOnLights(new Point(9, 9), new Point(9, 9));
        assertEquals(4, lightGrid.countLightsOn());
    }

    @Test
    void test10X10GridTurnOffLightsCorners() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOffLights(new Point(0, 9), new Point(0, 9));
        lightGrid.turnOffLights(new Point(9, 0), new Point(9, 0));
        lightGrid.turnOffLights(new Point(9, 9), new Point(9, 9));
        assertEquals(96, lightGrid.countLightsOn());
    }

    @Test
    void test10X10GridTurnOnPartialNoChangeIfWasAlreadyOnLights() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnOnLights(new Point(2, 2), new Point(8, 8));
        lightGrid.turnOnLights(new Point(2, 2), new Point(8, 8));
        assertEquals(49, lightGrid.countLightsOn());
    }


    @Test
    void test10X10GridTurnOffPartialNoChangeIfWasAlreadyOffLights() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(2, 2), new Point(8, 8));
        lightGrid.turnOffLights(new Point(2, 2), new Point(8, 8));
        assertEquals(51, lightGrid.countLightsOn());
    }

    @Test
    void testTurnOnLightsOutOfBoundsThrowException() {
        LightGrid lightGrid = new LightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOnLights(new Point(9, 9), new Point(10, 10)));
    }

    @Test
    void testTurnOffLightsOutOfBoundsThrowException() {
        LightGrid lightGrid = new LightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOffLights(new Point(9, 9), new Point(10, 10)));
    }

    @Test
    void testTurnOnLightsNegativeCoordinatesThrowException() {
        LightGrid lightGrid = new LightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOnLights(new Point(-1, 0), new Point(0, 0)));
    }

    @Test
    void testTurnOnLightsInvalidRangeThrows() {
        LightGrid lightGrid = new LightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOnLights(new Point(5, 5), new Point(4, 4)));
    }

    @Test
    void testTurnOffLightsInvalidRangeThrows() {
        LightGrid lightGrid = new LightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOffLights(new Point(5, 5), new Point(4, 4)));
    }

    @Test
    void testZeroSizeGridThrows() {
        assertThrows(IllegalArgumentException.class, () -> new LightGrid(0, 10));
    }

    @Test
    void testToggleLightsWhenOffTurnsLightsOn() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        assertEquals(100, lightGrid.countLightsOn());

    }

    @Test
    void testToggleLightsWhenOnTurnsLightsOff() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.countLightsOn());

    }

    @Test
    void testToggleLightsTwiceWhenOffKeepsLightsOff() {
        LightGrid lightGrid = new LightGrid(10, 10);
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.countLightsOn());

    }

    @Test
    void testToggleLightsOutOfBoundsThrowException() {
        LightGrid lightGrid = new LightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.toggleLights(new Point(9, 9), new Point(10, 10)));
    }

}
