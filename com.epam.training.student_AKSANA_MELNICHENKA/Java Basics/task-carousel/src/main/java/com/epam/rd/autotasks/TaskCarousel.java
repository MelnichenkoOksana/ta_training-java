package com.epam.rd.autotasks;

import java.util.ArrayList;

public class TaskCarousel {

    private ArrayList<Task> carousel;
    private int sizeCarousel;
    private int count;

    {
        count = 0;
    }

    public TaskCarousel(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Arguments can't be null");
        this.carousel = new ArrayList<>(capacity);
        this.sizeCarousel = capacity;
    }

    public boolean addTask(Task task) {
        if (!isFull() && !task.isFinished() ){
            this.carousel.add(task);
            return true;
        } else return false;
    }

    public boolean execute() {
        if (this.carousel.isEmpty()) {
            return false;
        }

        if (count >= this.carousel.size()) {
            count = 0;
        }

        if (!this.carousel.get(count).isFinished()) {
            carousel.get(count).execute();

            if (this.carousel.get(count).isFinished()){
                this.carousel.remove(count);
                count--;
            }
            count++;
            return true;
        } else {
            return false;
        }

    }

    public boolean isFull() {
        return (this.carousel.size() >= this.sizeCarousel);
    }

    public boolean isEmpty() {
        return  (this.carousel.size() == 0);
    }

}
