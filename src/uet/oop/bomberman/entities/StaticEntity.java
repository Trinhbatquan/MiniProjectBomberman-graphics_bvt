package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.irender.IRender;

public abstract class StaticEntity implements IRender {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;
    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;
    protected Image img;

    /**
     * author me.
     * @param xUnit xUnit coordinate
     * @param yUnit yUnit coordinate
     * @param img img coordinate
     */
    public StaticEntity(int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    @Override
    public abstract void update();

    public int getX() {
        int m = x / Sprite.SCALED_SIZE;
        return m;
    }
    public void setImg(Image img) {
        this.img = img;
    }

    public int getY() {
        int n = y / Sprite.SCALED_SIZE;
        return n;
    }

    @Override
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }
}

