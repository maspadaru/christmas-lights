package org.mspadaru.lights.grid;

import org.mspadaru.lights.model.Point;
import org.mspadaru.lights.util.GridUtils;

public class BrightnessLightGrid implements LightGrid {
    private static final int LIGHT_OFF = 0;

    private final int[][] grid;
    private final GridUtils utils;

    public BrightnessLightGrid(int xSize, int ySize) {
        this.utils = new GridUtils(xSize, ySize);
        grid = new int[xSize][ySize];
        Point start = new Point(0, 0);
        Point end = new Point(xSize - 1, ySize - 1);
        utils.forEachPoint(start, end, (x, y) -> grid[x][y] = LIGHT_OFF);
    }

    @Override
    public void turnOnLights(Point start, Point end) {
        utils.validateRange(start, end);
        utils.forEachPoint(start, end, (x, y) -> grid[x][y]++);
    }

    @Override
    public void turnOffLights(Point start, Point end) {
        utils.validateRange(start, end);
        utils.forEachPoint(start, end, (x, y) -> grid[x][y] = grid[x][y] > 0 ? grid[x][y] - 1 : LIGHT_OFF);
    }

    @Override
    public void toggleLights(Point start, Point end) {
        utils.validateRange(start, end);
        utils.forEachPoint(start, end, (x, y) -> grid[x][y] += 2);
    }

    @Override
    public int measureLights() {
        int total = 0;
        for (int[] row : grid) {
            for (int brightness : row) {
                total += brightness;
            }
        }
        return total;
    }
}
