package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public int getDegrees() {
        return degrees;
    }

    public static int dataNormalization (int degrees ){
        if ((degrees < 0 )|| (degrees >= 360)){
            if (degrees < 0){
                while (degrees <0) {
                    degrees = degrees + 360;
                }
            } else {
                while (degrees >= 360){
                    degrees = degrees - 360;
                }
            }
        }
        return degrees;
    }

   public static Direction ofDegrees(int degrees) {
       degrees = dataNormalization(degrees);

       for (Direction d : Direction.values()) {
           if (d.getDegrees() == degrees) return d;
       }
       return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = dataNormalization(degrees);

        if (degrees < 22){
            return Direction.N;
        } else if (degrees < 67){
            return Direction.NE;
        } else if (degrees < 112){
            return Direction.E;
        } else if (degrees < 157){
            return Direction.SE;
        } else if (degrees < 202){
            return Direction.S;
        } else if (degrees < 247){
            return Direction.SW;
        } else if (degrees < 292){
            return Direction.W;
        } else if (degrees < 337){
            return Direction.NW;
        } else if (degrees > 337){
            return Direction.N;
        }

        throw new UnsupportedOperationException();
    }

    public Direction opposite() {
        return ofDegrees(degrees+180);
    }

    public int differenceDegreesTo(Direction direction) {
        int result;
        result = Math.abs(this.getDegrees() - direction.getDegrees());
        if (result > 180) result = Math.abs(result - 360);
        return result;
    }
}
