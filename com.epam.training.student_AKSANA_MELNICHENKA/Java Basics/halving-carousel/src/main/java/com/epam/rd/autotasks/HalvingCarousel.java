package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run(){
        if (this.isFlagRun()) {

            CarouselRun run = new CarouselRun(1);
            this.setFlagRun(false);
            return run;
        } else {
            return null;
        }
    }



}
