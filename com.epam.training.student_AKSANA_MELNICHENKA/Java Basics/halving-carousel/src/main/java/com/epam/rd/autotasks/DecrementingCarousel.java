package com.epam.rd.autotasks;

public class DecrementingCarousel {
    public static int[] carousel;
    private int count;
    private boolean flagRun;

    {
        carousel = new  int[0];
        flagRun = true;
    }


    public DecrementingCarousel(int capacity) {
        carousel = new int[capacity];
    }


    public boolean addElement(int element){

        if ((count < carousel.length) && (element > 0) && flagRun){
            carousel[count] = element;
            count++;
            return true;
        } else {
            return false;
        }

//        throw new UnsupportedOperationException();
    }

    public CarouselRun run(){
        if (flagRun) {

            CarouselRun run = new CarouselRun();
            flagRun = false;
            return run;
        } else {
            return null;
        }
    }

    public boolean isFlagRun() {
        return flagRun;
    }

    public void setFlagRun(boolean flagRun) {
        this.flagRun = flagRun;
    }

    public int[] getCarousel() {
        return carousel;
    }

}
