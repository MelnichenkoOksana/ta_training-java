package com.epam.rd.autotasks;

public class CarouselRun{
    private int countElemNum;
    private int flagVersion;

    {
        countElemNum = 0;
    }

    public CarouselRun() {
        this.flagVersion = 0;
    }

    public CarouselRun(int flagVersion) {
        this.flagVersion = flagVersion;
    }

    public int next() {
        if (!isFinished()){

            if (countElemNum == DecrementingCarousel.carousel.length) countElemNum = 0;

            if (DecrementingCarousel.carousel[countElemNum] == 0){
                while (DecrementingCarousel.carousel[countElemNum] == 0){
                    countElemNum++;
                    if (countElemNum == DecrementingCarousel.carousel.length) countElemNum = 0;
                }
            }
            countElemNum++;
            if (this.flagVersion == 0) {
                return DecrementingCarousel.carousel[countElemNum-1]--;
            } else if (this.flagVersion == 1){
                int result = DecrementingCarousel.carousel[countElemNum-1];
                DecrementingCarousel.carousel[countElemNum-1] = (int) Math.floor(DecrementingCarousel.carousel[countElemNum-1]/2);
                return result;
            } else return -1;

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
        return flag;
    }
}
