package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{

    private int actionLimit;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {

        super(capacity);
        this.actionLimit = actionLimit;
    }

    @Override
    public CarouselRun run(){
        if (this.isFlagRun()) {

            CarouselRun run = new CarouselRun(actionLimit);
            this.setFlagRun(false);
            return run;
        } else {
            return null;
        }

    }
}
