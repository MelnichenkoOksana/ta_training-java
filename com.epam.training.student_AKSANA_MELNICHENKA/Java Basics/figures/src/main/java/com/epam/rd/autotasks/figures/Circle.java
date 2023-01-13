package com.epam.rd.autotasks.figures;

class Circle extends Figure {

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (center == null) throw new IllegalArgumentException("Center point can't be null");
        if (radius <=0 ) throw new IllegalArgumentException("Radius must be greater than 0");
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area(){
        return (Math.PI*Math.pow(radius, 2));
    }

    @Override
    public String pointsToString(){
        return "("+center.toString()+")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius+"]";
    }

    @Override
    public Point leftmostPoint(){
        return new Point(center.getX()-radius, center.getY());
    }

}
