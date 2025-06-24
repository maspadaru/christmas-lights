package org.mspadaru.lights.grid;

import org.mspadaru.lights.model.Point;

public interface LightGrid {

    void turnOnLights(Point start, Point end);

    void turnOffLights(Point start, Point end);

    void toggleLights(Point start, Point end);

    int measureLights();
}
