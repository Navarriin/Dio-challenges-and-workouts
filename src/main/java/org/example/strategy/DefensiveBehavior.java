package org.example.strategy;

public class DefensiveBehavior implements Behavior{

    @Override
    public void toMove() {
        System.out.println("Movendo-se Defensivamente...");
    }
}
