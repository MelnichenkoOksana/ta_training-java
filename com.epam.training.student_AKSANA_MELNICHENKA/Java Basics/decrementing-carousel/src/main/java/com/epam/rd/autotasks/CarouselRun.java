package com.epam.rd.autotasks;

public class CarouselRun{
    private int countElemNum;

    {
        countElemNum = 0;
    }

    public int next() {
        if (isFinished() == false){

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
            }
        }
        return flag;
    }
}
