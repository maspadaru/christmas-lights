package org.mspadaru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testTurnOnAllLightsTenTimes() {
        LightGrid lightGrid = new BrightnessLightGrid(1000, 1000);
        for (int i = 0; i < 10; i++) {
            lightGrid.turnOnLights(new Point(0, 0), new Point(999, 999));
        }
        assertEquals(10_000_000, lightGrid.measureLights());
    }


    @Test
    void testTurnOffOneLightOnce() {
        LightGrid lightGrid = new BrightnessLightGrid(1000, 1000);
        lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOffLights(new Point(0, 0), new Point(0, 0));
        assertEquals(0, lightGrid.measureLights());
    }

    @Test
    void testTurnOffOneLightTwoTimes() {
        LightGrid lightGrid = new BrightnessLightGrid(1000, 1000);
        for (int i = 0; i < 10; i++) {
            lightGrid.turnOnLights(new Point(0, 0), new Point(0, 0));
        }
        lightGrid.turnOffLights(new Point(0, 0), new Point(0, 0));
        lightGrid.turnOffLights(new Point(0, 0), new Point(0, 0));
        assertEquals(8, lightGrid.measureLights());
    }

    @Test
    void testTurnOffAllLightsTenTimes() {
        LightGrid lightGrid = new BrightnessLightGrid(1000, 1000);
        for (int i = 0; i < 10; i++) {
            lightGrid.turnOnLights(new Point(0, 0), new Point(999, 999));
        }
        for (int i = 0; i < 10; i++) {
            lightGrid.turnOffLights(new Point(0, 0), new Point(999, 999));
        }
        assertEquals(0, lightGrid.measureLights());
    }

}