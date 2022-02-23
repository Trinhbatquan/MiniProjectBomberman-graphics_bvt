package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;


public class Doll extends Enemy{

    public Doll(int xUnit, int yUnit, String velocity, Image img) {
        super(xUnit, yUnit, velocity, img);
    }


    protected int timeDoll = 30;
    @Override
    public void update() {
        super.update();

        //set up bot chạy
        if (timeDoll > 0) {
            timeDoll -= 1;
        } else {
            MoveDoll();
            timeDoll = 20;
        }
    }

    public void MoveDoll() {
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
