package org.mspadaru;

public class BrightnessLightGrid implements LightGrid {

    private final int[][] grid;

    public BrightnessLightGrid(int xSize, int ySize) {
            grid = new int[xSize][ySize];
            Point start = new Point(0, 0);
            Point end = new Point(xSize - 1, ySize - 1);

            for (int x = start.x(); x <= end.x(); x++) {
                for (int y = start.y(); y <= end.y(); y++) {
                    grid[x][y] = 0;
                }
            }
    }

    @Override
    public void turnOnLights(Point start, Point end) {
        for (int x = start.x(); x <= end.x(); x++) {
            for (int y = start.y(); y <= end.y(); y++) {
                grid[x][y]++;
            }
        }
    }

    @Override
    public void turnOffLights(Point start, Point end) {

    }

    @Override
    public void toggleLights(Point start, Point end) {

    }

    @Override
    public int measureLights() {
        int sum = 0;
        for (int x = 0; x <= grid.length-1; x++) {
            for (int y = 0; y <= grid[x].length-1; y++) {
                sum += grid[x][y];
            }
        }
        return sum;
    }
}
