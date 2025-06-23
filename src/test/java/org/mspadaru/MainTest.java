package org.mspadaru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void test1x1gridTuronLightsOn () {
        LightGrid lightGrid = new LightGrid(1,1);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(0, 0));
        assertEquals(1, lightGrid.countLightsOn());
    }

    @Test
    void test1x1gridTuronLightsOff () {
        LightGrid lightGrid = new LightGrid(1,1);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(0, 0));
        lightGrid.turnLightsOff(new Point(0, 0), new Point(0, 0));
        assertEquals(0, lightGrid.countLightsOn());
    }

}