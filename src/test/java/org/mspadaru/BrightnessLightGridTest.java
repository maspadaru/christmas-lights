package org.mspadaru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrightnessLightGridTest {

    @Test
    void testTurnOnOneLightOnce() {
        LightGrid lightGrid = new BrightnessLightGrid(1000, 1000);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        assertEquals(1, lightGrid.measureLights());
    }

    @Test
    void testTurnOnOneLightTwoTimes() {
        LightGrid lightGrid = new BrightnessLightGrid(1000, 1000);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        assertEquals(2, lightGrid.measureLights());
    }

    @Test
    void testTurnOnOneLightMaxTimes() {
        LightGrid lightGrid = new BrightnessLightGrid(1000, 1000);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        }
        assertEquals(Integer.MAX_VALUE, lightGrid.measureLights());
    }



}