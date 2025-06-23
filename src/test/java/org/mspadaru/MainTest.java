package org.mspadaru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void test1x1grid () {
        LightGrid lightGrid = new LightGrid(1,1);
        lightGrid.turnLightsOn(new Point(0, 0), new Point(0, 0));
        assertEquals(1, lightGrid.countLightsOn());
    }

}