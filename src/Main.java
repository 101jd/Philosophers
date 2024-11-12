import collection.Node;
import entities.Entity;
import entities.Philosopher;
import entities.Table;
import entities.builders.PhiloBuilder;

import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PhiloBuilder builder = new PhiloBuilder();
        Table table = new Table();

        table.add("Diogen")
                .add("Paracelse")
                .add("Leibnitz")
                .add("Nietzshe")
                .add("Dugin");


        for (Node<Entity> entity : table.getTable()){
            if (entity.get() instanceof Philosopher){
                new Thread((Philosopher) entity.get()).start();
            }
        }

    }
}