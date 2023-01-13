package com.epam.rd.autotasks.figures;

class Triangle extends Figure{

    private Point a;
    private Point b;
    private Point c;
    final float DELTA = 0.0001f;

    public Triangle(Point a, Point b, Point c) {
        Segment ab = new Segment(a, b);
        Segment ac = new Segment(a, c);
        Segment bc = new Segment(b, c);

        if (Math.abs(Segment.length(ab)+Segment.length(ac)-Segment.length(bc))<DELTA ||
                Math.abs(Segment.length(ac)+Segment.length(bc)-Segment.length(ab))<DELTA ||
                Math.abs(Segment.length(ab)+Segment.length(bc)-Segment.length(ac))<DELTA)
            throw new IllegalArgumentException("The triangle does not exist or is degenerate");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double ableng = Segment.length(new Segment(a, b));
        double acleng = Segment.length(new Segment(a, c));
        double bcleng = Segment.length(new Segment(b, c));

        double p = (ableng + acleng + bcleng)/2;
        return (Math.sqrt(p*(p-ableng)*(p-acleng)*(p-bcleng)));
    }

    @Override
    public Point centroid(){
        double x = 1.0/3.0 * (a.getX() + b.getX() + c.getX());
        double y = 1.0/3.0 * (a.getY() + b.getY() + c.getY());
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure){
        if (figure instanceof Triangle) {
            Point[] arrayFigure = {((Triangle) figure).a, ((Triangle) figure).b, ((Triangle) figure).c};
            Point[] arrayThis = {this.a, this.b, this.c};
            int count = 0;
            for (Point arrayThi : arrayThis) {
                for (Point point : arrayFigure) {
                    if (Math.abs(arrayThi.getX() - point.getX())< DELTA && Math.abs(arrayThi.getY() - point.getY())< DELTA) {
                        count++;
                        break;
                    }
                }
            }
            return count == 3;
        }
        return false;
    }
}
