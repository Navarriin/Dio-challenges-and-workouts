package org.example.strategy;

public class Robot {

    private Behavior strategy;

    public void setStrategy(Behavior strategy) {
        this.strategy = strategy;
    }

    public void toMove() {
        strategy.toMove();
    }
}
