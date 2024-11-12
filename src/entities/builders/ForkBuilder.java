package entities.builders;

import entities.Fork;

public class ForkBuilder {
    private int id = 0;
    public Fork build(){
        return new Fork(id++);
    }
}
