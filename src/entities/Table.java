package entities;

import collection.CircleList;
import collection.Node;
import entities.builders.ForkBuilder;
import entities.builders.PhiloBuilder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Table {
    private CircleList<Entity> table = new CircleList<>();
    private ForkBuilder forkBuilder = new ForkBuilder();
    private PhiloBuilder philoBuilder = new PhiloBuilder();

    public Table add(String name){
        if (table.isEmpty()){
            Fork left = forkBuilder.build();
            Fork right = forkBuilder.build();
            table.add(left);
            table.add(philoBuilder.buildPhilosopher(name, left, right));
            table.add(right);
        } else {
            Fork right = forkBuilder.build();
            table.add(philoBuilder.buildPhilosopher(name, (Fork) table.getTail().get(), right));
            table.add(right);
        }
        return this;
    }

    public CircleList<Entity> getTable() {
        return table;
    }

}
