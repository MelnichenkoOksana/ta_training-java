package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{

    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run(){
        if (this.isFlagRun()) {

            CarouselRun run = new CarouselRun(2);
            this.setFlagRun(false);
            return run;
        } else {
            return null;
        }
    }
}
