package org.mspadaru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinaryLightGridTest {

    @Test
    void test1X1GridTurnOnLights() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(1, 1);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        assertEquals(1, lightGrid.measureLights());
    }

    @Test
    void test1X1GridTurnOffLights() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(1, 1);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOffLights(new Point(0, 0), new Point(0, 0));
        assertEquals(0, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOnLights() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        assertEquals(100, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOffLights() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOnLightsPartial() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(2, 2), new Point(8, 8));
        assertEquals(49, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOffLightsPartial() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(2, 2), new Point(8, 8));
        assertEquals(51, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOnLightsCorners() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOnLights(new Point(0, 9), new Point(0, 9));
        lightGrid.turnOnLights(new Point(9, 0), new Point(9, 0));
        lightGrid.turnOnLights(new Point(9, 9), new Point(9, 9));
        assertEquals(4, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOffLightsCorners() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOffLights(new Point(0, 9), new Point(0, 9));
        lightGrid.turnOffLights(new Point(9, 0), new Point(9, 0));
        lightGrid.turnOffLights(new Point(9, 9), new Point(9, 9));
        assertEquals(96, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOnPartialNoChangeIfWasAlreadyOnLights() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(2, 2), new Point(8, 8));
        lightGrid.turnOnLights(new Point(2, 2), new Point(8, 8));
        assertEquals(49, lightGrid.measureLights());
    }


    @Test
    void test10X10GridTurnOffPartialNoChangeIfWasAlreadyOffLights() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(2, 2), new Point(8, 8));
        lightGrid.turnOffLights(new Point(2, 2), new Point(8, 8));
        assertEquals(51, lightGrid.measureLights());
    }

    @Test
    void testTurnOnLightsOutOfBoundsThrowException() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOnLights(new Point(9, 9), new Point(10, 10)));
    }

    @Test
    void testTurnOffLightsOutOfBoundsThrowException() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOffLights(new Point(9, 9), new Point(10, 10)));
    }

    @Test
    void testTurnOnLightsNegativeCoordinatesThrowException() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOnLights(new Point(-1, 0), new Point(0, 0)));
    }

    @Test
    void testTurnOnLightsInvalidRangeThrows() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOnLights(new Point(5, 5), new Point(4, 4)));
    }

    @Test
    void testTurnOffLightsInvalidRangeThrows() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.turnOffLights(new Point(5, 5), new Point(4, 4)));
    }

    @Test
    void testZeroSizeGridThrows() {
        assertThrows(IllegalArgumentException.class, () -> new BinaryLightGrid(0, 10));
    }

    @Test
    void testToggleLightsWhenOffTurnsLightsOn() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        assertEquals(100, lightGrid.measureLights());

    }

    @Test
    void testToggleLightsWhenOnTurnsLightsOff() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.measureLights());

    }

    @Test
    void testToggleLightsTwiceWhenOffKeepsLightsOff() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.measureLights());

    }

    @Test
    void testToggleLightsOutOfBoundsThrowException() {
        BinaryLightGrid lightGrid = new BinaryLightGrid(10, 10);
        assertThrows(IllegalArgumentException.class, () -> lightGrid.toggleLights(new Point(9, 9), new Point(10, 10)));
    }

}
