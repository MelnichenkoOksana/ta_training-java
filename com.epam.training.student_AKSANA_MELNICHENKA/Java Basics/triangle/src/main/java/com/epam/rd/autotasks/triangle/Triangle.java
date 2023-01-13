package com.epam.rd.autotasks.triangle;

class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        Segment ab = new Segment(a, b);
        Segment ac = new Segment(a, c);
        Segment bc = new Segment(b, c);

            if (Segment.length(ab)+Segment.length(ac)<=Segment.length(bc) ||
                Segment.length(ac)+Segment.length(bc)<=Segment.length(ab) ||
                Segment.length(ab)+Segment.length(bc)<=Segment.length(ac))
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

    public Point centroid(){
        Segment ab = new Segment(a, b);
        Segment ac = new Segment(a, c);
        Segment bc = new Segment(b, c);

        return (Segment.intersection(new Segment(a, Segment.middle(bc)), new Segment(b, Segment.middle(ac))));
    }

}
