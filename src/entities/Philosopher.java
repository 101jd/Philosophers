package entities;

import java.util.concurrent.CountDownLatch;

public class Philosopher implements Runnable, Entity{
    private int id;
    private String name;
    private int satiety;
    private Fork left;
    private Fork right;
    private boolean rightHand;
    private boolean leftHand;
    private boolean isThinking;
    private boolean isEating;
    CountDownLatch cdl;

    public Philosopher(int id, String name, Fork left, Fork right){
        this.id = id;
        this.name = name;
        this.satiety = 0;
        this.cdl = new CountDownLatch(3);
        this.rightHand = false;
        this.leftHand = false;
        this.isThinking = true;
        this.isEating = false;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (satiety < 3){
            System.out.println(eating());
            System.out.println(thinking());
        }
    }

    private int increaseSatiety(){
        return ++satiety;
    }

    public boolean getLeftFork(){
        synchronized (left) {
            return (leftHand = !left.isBusy() ? true : false);
        }
    }

    public boolean getRightFork(){
        synchronized (right){
            return (rightHand = !right.isBusy() ? true : false);
        }
    }

    public boolean eat(){
        if (getLeftFork() && getRightFork() && isThinking){
            isThinking = false;
            isEating = true;
            increaseSatiety();
            return true;
        }
        return false;
    }

    public String eating(){
        if (eat()){
            return this.name + ": I eat hence I exist";
        }
        return null;
    }

    public String thinking(){
        if (think()){
            return this.name + ": I think hence I exist";
        }
        return null;
    }

    public boolean think(){
        left.setBusy(false);
        right.setBusy(false);
        isEating = false;

        return (isThinking = true);
    }

    public int getId() {
        return id;
    }
}
