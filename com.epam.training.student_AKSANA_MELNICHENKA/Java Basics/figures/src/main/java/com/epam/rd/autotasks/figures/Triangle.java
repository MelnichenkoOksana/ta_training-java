package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area(){
        double ab = Segment.length(new Segment(a, b));
        double ac = Segment.length(new Segment(a, c));
        double bc = Segment.length(new Segment(b, c));

        double p = (ab + ac + bc)/2;
        return (Math.sqrt(p*(p-ab)*(p-ac)*(p-bc)));
    }

    @Override
    public String pointsToString(){
      return "("+ a.toString() + ")("+ b.toString() + ")(" + c.toString() + ")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint(){
        double x = a.getX();
        double y = a.getY();

        if (b.getX() < x) {
            x = b.getX();
            y = b.getY();
        }
        if (c.getX() < x) {
            x = c.getX();
            y = c.getY();
        }
        return new Point(x,y);
    }

}
