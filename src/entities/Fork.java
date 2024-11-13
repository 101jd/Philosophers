package entities;

public class Fork implements Entity {
    private int id;
    private boolean isBusy;
    public Fork(int id){
        this.id = id;
        isBusy = false;
    }

    public void setBusy(boolean b) {
        synchronized (this) {
            isBusy = b;
        }
    }

    public boolean isBusy() {
//        synchronized (this) {
            return isBusy;
//        }
    }

    public Fork get(){
        return this;
    }

    public int getId() {
        return id;
    }
}
