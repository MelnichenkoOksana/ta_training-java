package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private int flag;

    {
        flag = 0;
    }

    @Override
    public void execute() {
        if (flag == 1) flag++;
    }

    @Override
    public boolean isFinished() {
        return (flag == 2);
    }

    public void complete() {
        flag = 1;
    }
}
