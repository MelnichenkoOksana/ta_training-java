package com.epam.rd.autotasks;

public class Main {
    public static void main(String[] args) {
        DecrementingCarousel carousel = new HalvingCarousel(7);

        carousel.addElement(20);
        carousel.addElement(30);
        carousel.addElement(10);

        CarouselRun run = carousel.run();

        System.out.println(run.isFinished()); //false

        System.out.println(run.next()); //20
        System.out.println(run.next()); //30
        System.out.println(run.next()); //10

        System.out.println(run.next()); //10
        System.out.println(run.next()); //15
        System.out.println(run.next()); //5

        System.out.println(run.next()); //5
        System.out.println(run.next()); //7
        System.out.println(run.next()); //2

        System.out.println(run.next()); //2
        System.out.println(run.next()); //3
        System.out.println(run.next()); //1

        System.out.println(run.next()); //1
        System.out.println(run.next()); //1

        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }
}
