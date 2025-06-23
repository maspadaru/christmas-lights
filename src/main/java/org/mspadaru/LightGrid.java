package org.mspadaru;

public class LightGrid {
    private static final int LIGHT_OFF = 0;
    private static final int LIGHT_ON = 1;

    private final int[][] grid;

    public LightGrid(int xSize, int ySize) {
        grid = new int[xSize][ySize];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                grid[i][j] = LIGHT_OFF;
            }
        }
    }

    public void turnLightsOn(Point start, Point end) {
        for (int i = start.getX(); i <= end.getX(); i++) {
            for (int j = start.getY(); j <= end.getY(); j++) {
                grid[i][j] = LIGHT_ON;
            }
        }
    }

    public int countLightsOn() {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == LIGHT_ON) {
                    sum++;
                }
            }
        }
        return sum;
    }

}
