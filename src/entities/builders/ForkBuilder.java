package entities.builders;

import entities.Fork;

public class ForkBuilder {
    private int id;
    public ForkBuilder(){
        id = 1;
    }
    public Fork build(){
        return new Fork(this.id++);
    }
}
