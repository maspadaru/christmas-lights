package org.mspadaru.util;

import org.mspadaru.Point;

public class GridUtils {
    private final int width;
    private final int height;

    public GridUtils(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Grid dimensions must be positive");
        }
        this.width = width;
        this.height = height;
    }

    public void validateRange(Point start, Point end) {
        if (!isPointWithinBounds(start) || !isPointWithinBounds(end) || !isValidRange(start, end)) {
            throw new IllegalArgumentException("Invalid point range");
        }
    }

    public boolean isPointWithinBounds(Point point) {
        return point.x() >= 0 && point.y() >= 0 && point.x() < width && point.y() < height;
    }

    public boolean isValidRange(Point start, Point end) {
        return start.x() <= end.x() && start.y() <= end.y();
    }

    public void forEachPoint(Point start, Point end, BiIntConsumer action) {
        for (int x = start.x(); x <= end.x(); x++) {
            for (int y = start.y(); y <= end.y(); y++) {
                action.accept(x, y);
            }
        }
    }

    @FunctionalInterface
    public interface BiIntConsumer {
        void accept(int x, int y);
    }
}