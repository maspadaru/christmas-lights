package org.mspadaru.util;

import org.junit.jupiter.api.Test;
import org.mspadaru.Point;

import static org.junit.jupiter.api.Assertions.*;

class GridUtilsTest {

    @Test
    void testValidateRangeOutOfBoundsThrowException() {
        GridUtils utils = new GridUtils(1000, 1000);
        assertThrows(IllegalArgumentException.class, () -> utils.validateRange(new Point(9, 9), new Point(1000, 1000)));
    }

    @Test
    void testValidateRangeNegativeCoordinatesThrowException() {
        GridUtils utils = new GridUtils(1000, 1000);
        assertThrows(IllegalArgumentException.class, () -> utils.validateRange(new Point(-1, 0), new Point(0, 0)));
    }

    @Test
    void testValidateRangeInvalidRangeThrows() {
        GridUtils utils = new GridUtils(1000, 1000);
        assertThrows(IllegalArgumentException.class, () -> utils.validateRange(new Point(5, 5), new Point(4, 4)));
    }

    @Test
    void testZeroSizeGridThrows() {
        assertThrows(IllegalArgumentException.class, () -> new GridUtils(0, 10));
    }

}