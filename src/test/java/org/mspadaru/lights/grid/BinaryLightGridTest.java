package org.mspadaru.lights.grid;

import org.junit.jupiter.api.Test;
import org.mspadaru.lights.model.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryLightGridTest {

    @Test
    void test1X1GridTurnOnLights() {
        LightGrid lightGrid = new BinaryLightGrid(1, 1);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        assertEquals(1, lightGrid.measureLights());
    }

    @Test
    void test1X1GridTurnOffLights() {
        LightGrid lightGrid = new BinaryLightGrid(1, 1);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOffLights(new Point(0, 0), new Point(0, 0));
        assertEquals(0, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOnLights() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        assertEquals(100, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOffLights() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOnLightsPartial() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(2, 2), new Point(8, 8));
        assertEquals(49, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOffLightsPartial() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(2, 2), new Point(8, 8));
        assertEquals(51, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOnLightsCorners() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOnLights(new Point(0, 9), new Point(0, 9));
        lightGrid.turnOnLights(new Point(9, 0), new Point(9, 0));
        lightGrid.turnOnLights(new Point(9, 9), new Point(9, 9));
        assertEquals(4, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOffLightsCorners() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOffLights(new Point(0, 9), new Point(0, 9));
        lightGrid.turnOffLights(new Point(9, 0), new Point(9, 0));
        lightGrid.turnOffLights(new Point(9, 9), new Point(9, 9));
        assertEquals(96, lightGrid.measureLights());
    }

    @Test
    void test10X10GridTurnOnPartialNoChangeIfWasAlreadyOnLights() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(2, 2), new Point(8, 8));
        lightGrid.turnOnLights(new Point(2, 2), new Point(8, 8));
        assertEquals(49, lightGrid.measureLights());
    }


    @Test
    void test10X10GridTurnOffPartialNoChangeIfWasAlreadyOffLights() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.turnOffLights(new Point(2, 2), new Point(8, 8));
        lightGrid.turnOffLights(new Point(2, 2), new Point(8, 8));
        assertEquals(51, lightGrid.measureLights());
    }

    @Test
    void testToggleLightsWhenOffTurnsLightsOn() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        assertEquals(100, lightGrid.measureLights());

    }

    @Test
    void testToggleLightsWhenOnTurnsLightsOff() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.turnOnLights(new Point(0, 0), new Point(9, 9));
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.measureLights());

    }

    @Test
    void testToggleLightsTwiceWhenOffKeepsLightsOff() {
        LightGrid lightGrid = new BinaryLightGrid(10, 10);
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        lightGrid.toggleLights(new Point(0, 0), new Point(9, 9));
        assertEquals(0, lightGrid.measureLights());

    }

}
