package org.example.strategy;

public class OffensiveBehavior implements Behavior{

    @Override
    public void toMove() {
        System.out.println("Movendo-se Ofensivamente...");
    }
}
