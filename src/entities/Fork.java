package entities;

public class Fork implements Entity {
    private int id;
    private boolean isBusy;
    public Fork(int id){
        isBusy = false;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public boolean isBusy() {
        synchronized (this) {
            return isBusy;
        }
    }

    public Fork get(){
        return this;
    }
}
