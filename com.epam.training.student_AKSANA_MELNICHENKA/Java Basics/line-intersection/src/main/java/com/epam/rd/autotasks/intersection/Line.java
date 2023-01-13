package com.epam.rd.autotasks.intersection;

public class Line {
    public final int k, b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;

    }

    public Point intersection(Line other) {
        try {
            int x = (other.b - this.b) / (this.k - other.k);
            int y = this.k * x + this.b;

            return new Point(x, y);
        } catch (Exception e) {
            return null;
        }
    }

}
