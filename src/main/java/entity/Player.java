package entity;

public class Player {

    private boolean hasKey;
    private boolean hasHint;
    private boolean isDie;

    public Player(){
        this.hasHint = false;
        this.hasKey = false;
        this.isDie = false;
    }

    public boolean hasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean hasHint() {
        return hasHint;
    }

    public void setHasHint(boolean hasHint) {
        this.hasHint = hasHint;
    }

    public boolean isDie(){
        return isDie;
    }

    public void setDie(boolean isDie){
        this.isDie = isDie;
    }
}