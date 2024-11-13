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

    private boolean getLeftFork(){
            if (!left.isBusy()){
                left.setBusy(true);
                leftHand = true;
                return true;
            } else return false;
    }

    private boolean getRightFork(){
            if (!right.isBusy()){
                right.setBusy(true);
                rightHand = true;
                return true;
            } else return false;
    }

    private boolean tryGetForks(){
        if (!left.isBusy() && !right.isBusy()){
            left.setBusy(true);
            right.setBusy(true);
            leftHand = true;
            rightHand = true;
            return true;
        } else return false;
    }

    private boolean eat(){
        if (tryGetForks() && isThinking){
            System.out.println(name + " catched " + left.getId() + " & " + right.getId());
            isThinking = false;
            isEating = true;
            increaseSatiety();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return true;
        } else {
            System.out.println(name + " can't catch forks :( " + left.getId() + left.isBusy() + " " + right.getId() + right.isBusy());
            return false;
        }
    }

    public String eating(){
        if (eat()){
            return this.name + ": I eat hence I exist";
        }
        return name + " can't eat";
    }

    public String thinking(){
        if (think()){
            return this.name + ": I think hence I exist";
        }
        return name + " can't think";
    }

    private boolean think(){
        if (leftHand && rightHand) {
            left.setBusy(false);
            right.setBusy(false);
            leftHand = false;
            rightHand = false;
            System.out.println(name + " release " + left.getId() + " & " + right.getId());
        }
        isEating = false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return (isThinking = true);
    }

    public int getId() {
        return id;
    }

    public void setRight(Fork right) {
        this.right = right;
    }
}
