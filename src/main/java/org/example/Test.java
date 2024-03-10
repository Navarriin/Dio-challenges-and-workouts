package org.example;

import org.example.facade.Facade;
import org.example.singleton.semSpring.SingletonEager;
import org.example.singleton.semSpring.SingletonLazy;
import org.example.singleton.semSpring.SingletonLazyHolder;
import org.example.strategy.*;

public class Test {
    public static void main(String[] args) {

        // Testes relacionados a Design Patters
        // Singleton
        SingletonLazy lazy = SingletonLazy.getInstance();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstance();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstance();
        System.out.println(eager);
        eager = SingletonEager.getInstance();
        System.out.println(eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);

        System.out.println("------------------");

        // Strategy
        Behavior normalRobot = new NormalBehavior();
        Behavior offensiveRobot = new OffensiveBehavior();
        Behavior defensiveRobot = new DefensiveBehavior();

        Robot robot = new Robot();

        robot.setStrategy(normalRobot);
        robot.toMove();
        robot.setStrategy(offensiveRobot);
        robot.toMove();
        robot.setStrategy(defensiveRobot);
        robot.toMove();

        System.out.println("------------------");

        // Facade
        Facade instance = new Facade();
        instance.migrateClient("Gabriel", "132.224.312-50");

    }
}

