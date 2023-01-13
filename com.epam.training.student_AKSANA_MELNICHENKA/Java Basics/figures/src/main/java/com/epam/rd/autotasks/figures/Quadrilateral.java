package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area(){
        Triangle abc = new Triangle(this.a, this.b, this.c);
        Triangle acd = new Triangle(this.a, this.c, this.d);

        return (abc.area()+acd.area());

    }

    @Override
    public String pointsToString(){
        return "("+ a.toString() + ")("+ b.toString() + ")(" + c.toString() + ")(" + d.toString() + ")";
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
        if (d.getX() < x) {
            x = d.getX();
            y = d.getY();
        }

        return new Point(x,y);
    }

    }
