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

    public static Point middle(Segment segment) {
        return new Point( (segment.start.getX() + segment.end.getX()) / 2,(segment.start.getY() + segment.end.getY()) / 2 );
    }

    public static Point intersection(Segment first, Segment second) {
        double slopeFirst = first.getSlope(first.start, first.end);
        double slopeSecond = first.getSlope(second.start, second.end);

        double freeTermsFirst = first.getFreeTerms(first, slopeFirst);
        double freeTermsSecond = first.getFreeTerms(second, slopeSecond);

        if (checkParallelism(slopeFirst, slopeSecond) || checkCollinear(first, second)){
            return null;
        } else {
            try {
                double x = (freeTermsSecond - freeTermsFirst)/(slopeFirst - slopeSecond);
                double y = slopeFirst*x +freeTermsFirst;

                if (checkBelongPointToSegment(first, new Point(x,y)) && checkBelongPointToSegment(second, new Point(x,y))) {
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

    static boolean checkParallelism(double slopeFirst, double slopeSecond){
        return (slopeFirst == slopeSecond);
    }

    static boolean checkCollinear(Segment first, Segment second){
        return ((first.end.getX() - first.start.getX())/(second.end.getX() - second.start.getX()) == (first.end.getY() - first.start.getY())/(second.end.getY() - second.start.getY()));
    }

    static boolean checkBelongPointToSegment(Segment segment, Point point){
        if (segment.start.getX() >= segment.end.getX()){
            return ((segment.end.getX() <= point.getX()) &&(point.getX() <= segment.start.getX()));
        } else {
            return ((segment.start.getX() <= point.getX()) &&(point.getX() <= segment.end.getX()));
        }

    }

    @Override
    public String toString() {
        return "Segment{" +
                "start=" + start.toString() +
                ", end=" + end.toString() +
                '}';
    }
}

