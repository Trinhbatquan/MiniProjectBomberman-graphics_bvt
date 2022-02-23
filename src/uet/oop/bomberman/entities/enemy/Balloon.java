package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Balloon extends Enemy {
    public int timeBollon = 60;

    /**
     * author me.
     * @param xUnit xUnit coordinate
     * @param yUnit yUnit coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public Balloon(int xUnit, int yUnit, String name, Image img) {
        super(xUnit, yUnit, name, img);
    }

    public void update() {
        super.update();

        // set up chạy cho bot
        if (timeBollon > 0) {
            timeBollon -= 1;
        } else {
            MoveBollon();
            timeBollon = 40;
        }
    }

    // dùng random
    public void MoveBollon(){
        double value = Math.random();
        if(value < 0.25){
            moveUp();
            img = Sprite.balloom_left2.getFxImage();
        }
        else if(value < 0.5){
            img = Sprite.balloom_right2.getFxImage();
            moveDown();
        }
        else if(value < 0.75){
            img = Sprite.balloom_left1.getFxImage();
            moveLeft();
        }
        else {
            img = Sprite.balloom_right1.getFxImage();
            moveRight();
        }
    }

    @Override
    public void animate() {
        super.animate();
    }

    @Override
    public void checkDead() {
        checkDead = true;
    }

    @Override
    public void remove() {
        super.remove();
    }
}

