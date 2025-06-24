package org.mspadaru;

public interface LightGrid {

    void turnOnLights(Point start, Point end);

    void turnOffLights(Point start, Point end);

    void toggleLights(Point start, Point end);

    int measureLights();
}
