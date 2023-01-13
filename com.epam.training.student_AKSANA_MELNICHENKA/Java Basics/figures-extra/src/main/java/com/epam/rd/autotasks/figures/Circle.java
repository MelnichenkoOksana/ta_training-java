package com.epam.rd.autotasks.figures;

class Circle extends Figure{

    private Point center;
    private double radius;
    final float DELTA = 0.0001f;

    public Circle(Point center, double doubleRadius) {
        if (center == null) throw new IllegalArgumentException("Center point can't be null");
        if (doubleRadius <=0 ) throw new IllegalArgumentException("Radius must be greater than 0");
        this.center = center;
        this.radius = doubleRadius/2;
    }


    @Override
    public Point centroid(){
        return this.center;
    }

    @Override
    public boolean isTheSame(Figure figure){
        if (figure instanceof Circle) {
            return Math.abs(this.center.getX() - ((Circle) figure).center.getX()) < DELTA &&
                    Math.abs(this.center.getY() - ((Circle) figure).center.getY()) < DELTA &&
                    Math.abs(this.radius - ((Circle) figure).radius) < DELTA;
        }
        return false;
    }

}
