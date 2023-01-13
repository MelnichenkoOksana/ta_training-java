package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    final float DELTA = 0.0001f;

    public Quadrilateral(Point a, Point b, Point c, Point d) {

        if ((a == null)||(b == null)||(c == null)||(d==null))
            throw new IllegalArgumentException("Point can't be null");

        if (!isNonDegenerativeConvexQuadrilateral(a, b, c, d))
            throw new IllegalArgumentException("The quadrilateral does not exist or is degenerate");

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public Point centroid(){
        Triangle abc = new Triangle(a, b, c);
        Triangle acd = new Triangle(a, c, d);
        Triangle abd = new Triangle(a, b, d);
        Triangle bcd = new Triangle(b, c, d);

        return Segment.intersection(new Segment(abc.centroid(), acd.centroid()), new Segment(abd.centroid(), bcd.centroid()));
    }

    @Override
    public boolean isTheSame(Figure figure){
        if (figure instanceof Quadrilateral) {
            Point[] arrayFigure = {((Quadrilateral) figure).a, ((Quadrilateral) figure).b, ((Quadrilateral) figure).c, ((Quadrilateral) figure).d};
            Point[] arrayThis = {this.a, this.b, this.c, this.d};
            int count = 0;
            for (Point arrayThi : arrayThis) {
                for (Point point : arrayFigure) {
                    if (Math.abs(arrayThi.getX() - point.getX())< DELTA && Math.abs(arrayThi.getY() - point.getY())< DELTA) {
                        count++;
                        break;
                    }
                }
            }
            return count == 4;
        }
        return false;
    }

    public boolean isNonDegenerativeConvexQuadrilateral(Point a, Point b, Point c, Point d){
        boolean flag = true;

        try {
            Point o = Segment.intersection(new Segment(a, c), new Segment(b, d));
            Triangle abo = new Triangle(a, b, o);
            Triangle bco = new Triangle(d, c, o);
            Triangle cdo = new Triangle(c, d, o);
            Triangle ado = new Triangle(a, d, o);
        }catch (Exception e) {
            flag = false;
        }

        return flag;
    }
}
