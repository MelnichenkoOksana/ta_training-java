package com.epam.rd.autotasks;

public class Main {
    public static void main(String[] args) {
        DecrementingCarousel carousel = new GraduallyDecreasingCarousel(7);

        carousel.addElement(7);
        carousel.addElement(2);
        carousel.addElement(3);
        carousel.addElement(1);
        carousel.addElement(4);

        CarouselRun run = carousel.run();

        System.out.println(run.isFinished()); //false

        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());

        System.out.println("Новый круг -1 ");

        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());

        System.out.println("Новый круг -2");

        System.out.println(run.next());
        System.out.println(run.next());

        System.out.println("Новый круг -3");
        System.out.println(run.next());


        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }
}
