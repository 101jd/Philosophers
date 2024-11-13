package entities.builders;

import entities.Fork;
import entities.Philosopher;

public class PhiloBuilder {
    private int id;
    public PhiloBuilder(){
        id = 1;
    }
    public Philosopher buildPhilosopher(String name, Fork left, Fork right){
        return new Philosopher(id++, name, left, right);
    }
}
