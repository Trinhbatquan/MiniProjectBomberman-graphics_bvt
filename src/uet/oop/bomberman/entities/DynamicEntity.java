package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.irender.IRender;

public abstract class DynamicEntity implements IRender, Collider {
    protected int blood = 0;
    protected boolean die = false;
    protected boolean symbol = false;
    protected double velocity;
    protected String name;
    protected Image img;
    protected int x;
    protected int y;
    protected int SCALE_SIZE = Sprite.SCALED_SIZE;
    public boolean checkDead = false;
    protected int timeGame = 60;

    public DynamicEntity() {

    }

    /**
     * author me.
     * @param x x coordinate
     * @param y y coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public DynamicEntity(int x, int y, String name, Image img){
        this.x = x * Sprite.SCALED_SIZE;
        this.y = y * Sprite.SCALED_SIZE;
        this.name = name;
        this.img = img;
    }

    public DynamicEntity(int x, int y, String name, Image img, double velocity){
        this.x = x * Sprite.SCALED_SIZE;
        this.y = y * Sprite.SCALED_SIZE;
        this.name = name;
        this.img = img;
        this.velocity = velocity;
    }

    public void checkDead() {
        if (blood > 0) {
            blood--;
        }
        else
            checkDead = true;
    }

    public void update() {
        if(checkDead == true) {
            animate();
            timeGame--;
            if(timeGame == 0)
                remove();
        }
    }

    public abstract void animate();
    public abstract void remove();

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public int getX(){
        int k = x / Sprite.SCALED_SIZE;
        return k;
    }

    public int getY(){
        int h = y / Sprite.SCALED_SIZE;
        return h;
    }
    public double getVelocity(){
        return velocity;
    }

    public boolean isDie(){
        return die;
    }
    public boolean isSymbol(){
        return symbol;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }

    @Override
    public boolean collide(DynamicEntity other) {
        return false;
    }
}

