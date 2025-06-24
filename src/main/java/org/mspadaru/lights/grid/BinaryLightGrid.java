package org.mspadaru.lights.grid;

import org.mspadaru.lights.model.Point;
import org.mspadaru.lights.util.GridUtils;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryLightGrid implements LightGrid {
    private static final int LIGHT_OFF = 0;
    private static final int LIGHT_ON = 1;

    private final int[][] grid;
    private final GridUtils utils;

    public BinaryLightGrid(int xSize, int ySize) {
        this.utils = new GridUtils(xSize, ySize);
        grid = new int[xSize][ySize];
        Point start = new Point(0, 0);
        Point end = new Point(xSize - 1, ySize - 1);
        utils.forEachPoint(start, end, (x, y) -> grid[x][y] = LIGHT_OFF);
    }

    @Override
    public void turnOnLights(Point start, Point end) {
        utils.validateRange(start, end);
        utils.forEachPoint(start, end, (x, y) -> grid[x][y] = LIGHT_ON);
    }

    @Override
    public void turnOffLights(Point start, Point end) {
        utils.validateRange(start, end);
        utils.forEachPoint(start, end, (x, y) -> grid[x][y] = LIGHT_OFF);
    }


    @Override
    public void toggleLights(Point start, Point end) {
        utils.validateRange(start, end);
        utils.forEachPoint(start, end, (x, y) -> grid[x][y] = grid[x][y] == LIGHT_OFF ? LIGHT_ON : LIGHT_OFF);
    }

    @Override
    public int measureLights() {
        AtomicInteger total = new AtomicInteger(0);
        Point start = new Point(0, 0);
        Point end = new Point(grid.length - 1, grid[0].length - 1);
        utils.forEachPoint(start, end, (x, y) -> {
            if (grid[x][y] == LIGHT_ON) {
                total.incrementAndGet();
            }
        });
        return total.get();
    }

}
