package org.example.strategy;

public class NormalBehavior implements Behavior{

    @Override
    public void toMove() {
        System.out.println("Movendo-se normalmente...");
    }
}
