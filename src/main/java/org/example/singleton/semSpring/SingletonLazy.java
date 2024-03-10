package org.example.singleton.semSpring;
import java.util.Objects;

public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy(){
        super();
    }

    public static SingletonLazy getInstance(){
        if(Objects.isNull(instance)) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
