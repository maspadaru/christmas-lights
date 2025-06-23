package org.mspadaru;

import java.util.concurrent.atomic.AtomicInteger;

public class LightGrid {
    private static final int LIGHT_OFF = 0;
    private static final int LIGHT_ON = 1;

    private final int[][] grid;

    public LightGrid(int xSize, int ySize) {
        grid = new int[xSize][ySize];
        Point start = new Point(0, 0);
        Point end = new Point(xSize - 1, ySize - 1);
        forEachPoint(start, end, (x, y) -> grid[x][y] = LIGHT_OFF);
    }

    public void turnLightsOn(Point start, Point end) {
        forEachPoint(start, end, (x, y) -> grid[x][y] = LIGHT_ON);
    }

    public int countLightsOn() {
        AtomicInteger total = new AtomicInteger(0);
        Point start = new Point(0, 0);
        Point end = new Point(grid.length - 1, grid[0].length - 1);
        forEachPoint(start, end, (x, y) -> {
            if (grid[x][y] == LIGHT_ON) {
                total.incrementAndGet();
            }
        });
        return total.get();
    }

    private void forEachPoint(Point start, Point end, IntConsumer2D action) {
        for (int x = start.getX(); x <= end.getX(); x++) {
            for (int y = start.getY(); y <= end.getY(); y++) {
                action.accept(x, y);
            }
        }
    }

    @FunctionalInterface
    private interface IntConsumer2D {
        void accept(int x, int y);
    }

}
