package org.mspadaru;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryLightGrid implements LightGrid {
    private static final int LIGHT_OFF = 0;
    private static final int LIGHT_ON = 1;

    private final int[][] grid;

    public BinaryLightGrid(int xSize, int ySize) {
        if (isGridSizeValid(xSize, ySize)) {
            grid = new int[xSize][ySize];
            Point start = new Point(0, 0);
            Point end = new Point(xSize - 1, ySize - 1);
            forEachPoint(start, end, (x, y) -> grid[x][y] = LIGHT_OFF);
        } else {
            throw new IllegalArgumentException("Grid dimesions cannot be zero");
        }
    }

    @Override
    public void turnOnLights(Point start, Point end) {
        validateRange(start, end);
        forEachPoint(start, end, (x, y) -> grid[x][y] = LIGHT_ON);
    }

    @Override
    public void turnOffLights(Point start, Point end) {
        validateRange(start, end);
        forEachPoint(start, end, (x, y) -> grid[x][y] = LIGHT_OFF);
    }


    @Override
    public void toggleLights(Point start, Point end) {
        validateRange(start, end);
        forEachPoint(start, end, (x, y) -> grid[x][y] = grid[x][y] == LIGHT_OFF ? LIGHT_ON : LIGHT_OFF);
    }

    @Override
    public int measureLights() {
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

    private void validateRange(Point start, Point end) {
        if (!isPointWithinBounds(start) || !isPointWithinBounds(end) || !isValidRange(start, end)) {
            throw new IllegalArgumentException("Points are out of bounds or range is invalid");
        }
    }

    private boolean isValidRange(Point start, Point end) {
        return start.x() <= end.x() && start.y() <= end.y();
    }

    private boolean isPointWithinBounds(Point point) {
        return point.x() >= 0 && point.y() >= 0 && point.x() < grid.length && point.y() < grid[0].length;
    }

    private boolean isGridSizeValid(int x, int y) {
        return x > 0 && y > 0;
    }

    private void forEachPoint(Point start, Point end, IntConsumer2D action) {
        for (int x = start.x(); x <= end.x(); x++) {
            for (int y = start.y(); y <= end.y(); y++) {
                action.accept(x, y);
            }
        }
    }

    @FunctionalInterface
    private interface IntConsumer2D {
        void accept(int x, int y);
    }

}
