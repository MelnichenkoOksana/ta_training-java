package com.epam.rd.autotasks;

public class CarouselRun{
    private int countElemNum;
    private int actionLimit;
    private int countNextOperation;

    {
        countElemNum = 0;
        countNextOperation = 0;
    }

    public CarouselRun() {
        this.actionLimit = -1;
    }

    public CarouselRun(int actionLimit) {
        this.actionLimit = actionLimit;
    }



    public int next() {

        if (!isFinished()){
            countNextOperation++;
            if (countElemNum == DecrementingCarousel.carousel.length) countElemNum = 0;

            if (DecrementingCarousel.carousel[countElemNum] == 0){
                while (DecrementingCarousel.carousel[countElemNum] == 0){
                    countElemNum++;
                    if (countElemNum == DecrementingCarousel.carousel.length) countElemNum = 0;
                }
            }
            countElemNum++;
            return DecrementingCarousel.carousel[countElemNum-1]--;

        } else return -1;
    }

    public boolean isFinished() {
        boolean flag = true;

        for (int elem:
                DecrementingCarousel.carousel) {
            if (elem > 0) {
                flag = false;
                break;
            }
        }

        if (actionLimit != -1){
            if (countNextOperation >= actionLimit) {
                flag = true;
            }
        }
        return flag;
    }

}
