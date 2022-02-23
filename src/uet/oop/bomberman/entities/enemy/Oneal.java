package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.audio.Audio;

public class Oneal extends Enemy{
    public Oneal(int xUnit, int yUnit, String velocity, Image img) {
        super(xUnit, yUnit, velocity, img);
    }
    protected int timeOneal = 30;
    @Override
    public void update() {
        super.update();
        if (timeOneal > 0) {
            timeOneal -= 1;
        } else {
            MoveOneal();
            timeOneal = 20;
        }
    }

    public void MoveOneal() {
        double value = Math.random();
        if(value < 0.25){
            moveUp();
        }
        else if(value < 0.5){
            moveDown();
        }
        else if(value < 0.75){
            moveLeft();
        }
        else {
            moveRight();
        }
    }

    @Override
    public void animate() {
        super.animate();
    }

    @Override
    public void remove() {
        super.remove();
    }
}

