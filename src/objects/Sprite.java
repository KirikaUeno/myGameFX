package objects;

public abstract class Sprite {

    protected double x;
    protected double y;
    protected double dx;
    protected double dy;

    public abstract void move();

    public int getY(){
        return (int)this.y;
    }
    public int getX(){
        return (int)this.x;
    }
}
