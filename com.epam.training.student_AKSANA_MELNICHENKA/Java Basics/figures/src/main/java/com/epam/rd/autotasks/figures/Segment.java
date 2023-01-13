package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start == null || end == null)
            throw new IllegalArgumentException("Arguments can't be null");
        if (start.getX() == end.getX() && start.getY() == end.getY())
            throw new IllegalArgumentException("The points must differ");
        this.start = start;
        this.end = end;
    }

    public static double length(Segment segment) {
        double xTempSquare = pow(segment.start.getX() - segment.end.getX(), 2);
        double yTempSquare = pow(segment.start.getY() - segment.end.getY(), 2);
        return sqrt(xTempSquare + yTempSquare);
    }

}
