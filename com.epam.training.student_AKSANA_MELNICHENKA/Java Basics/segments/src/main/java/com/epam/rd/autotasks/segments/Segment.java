package com.epam.rd.autotasks.segments;

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

    double length() {
        double xTempSquare = pow(start.getX() - end.getX(), 2);
        double yTempSquare = pow(start.getY() - end.getY(), 2);
        return sqrt(xTempSquare + yTempSquare);
    }

    Point middle() {
        return new Point( (start.getX() + end.getX()) / 2,(start.getY() + end.getY()) / 2 );
    }

    Point intersection(Segment another) {
        double slopeThis = this.getSlope(this.start, this.end);
        double slopeAnother = this.getSlope(another.start, another.end);

        double freeTermsThis = this.getFreeTerms(this, slopeThis);
        double freeTermsAnother = this.getFreeTerms(another, slopeAnother);

        if (checkParallelism(slopeThis, slopeAnother) || checkCollinear(this, another)){
            return null;
        } else {
            try {
                double x = (freeTermsAnother - freeTermsThis)/(slopeThis - slopeAnother);
                double y = slopeThis*x +freeTermsThis;

                if (checkBelongPointToSegment(this, new Point(x,y)) && checkBelongPointToSegment(another, new Point(x,y))) {
                    return new Point(x,y);
                } else {
                    return null;
                }
            }catch (Exception e){}
        }
        return null;
    }

    double getSlope(Point start, Point end){

        double slope;
        if (start.getX() >= end.getX()){
            slope = (end.getY() - start.getY())/(end.getX()-start.getX());
        } else {
            slope = (start.getY()-end.getY()) / (start.getX()-end.getX());
        }
        return slope;
    }

    double getFreeTerms (Segment segment, double slope){
        double freeTerms;

        if (segment.start.getX() >= segment.end.getX()){
            freeTerms = segment.end.getY() - slope*segment.end.getX();
        } else {
            freeTerms = segment.start.getY() - slope*segment.start.getX();
        }
        return freeTerms;
    }

    boolean checkParallelism(double slopeFirst, double slopeSecond){
        return (slopeFirst == slopeSecond);
    }

    boolean checkCollinear(Segment first, Segment second){
        return ((first.end.getX() - first.start.getX())/(second.end.getX() - second.start.getX()) == (first.end.getY() - first.start.getY())/(second.end.getY() - second.start.getY()));
    }

    boolean checkBelongPointToSegment(Segment segment, Point point){
        //        Шаг 2. Если x1 ≥ x2 то  меняем между собой значения x1 и  x2  и y1 и  y2
        if (segment.start.getX() >= segment.end.getX()){
            return ((segment.end.getX() <= point.getX()) &&(point.getX() <= segment.start.getX()));
        } else {
            return ((segment.start.getX() <= point.getX()) &&(point.getX() <= segment.end.getX()));
        }

    }

}
