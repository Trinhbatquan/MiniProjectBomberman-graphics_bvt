package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.ai.AIMedium;
import uet.oop.bomberman.entities.move.Bomber;


public class Minvo extends Enemy{

    /**
     * author me.
     * @param xUnit xUnit coordinate
     * @param yUnit yUnit coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public Minvo(int xUnit, int yUnit, String name, Image img) {
        super(xUnit, yUnit, name, img);
        blood = 0;
    }
    protected int timeMinvo = 30;
    @Override
    public void update() {
        super.update();

        //setup bot chạy
        if (timeMinvo > 0) {
            timeMinvo -= 1;
        } else {
            boolean sameComponent = BombermanGame.MapgameLoad.index.connected(BombermanGame.MapgameLoad.UFvalue(getY(), getX()),
                    BombermanGame.MapgameLoad.UFvalue(Bomber.GETY(), Bomber.GETX()));
            if(sameComponent){
                MoveDistanceMinvo();
            }
            else{
               MoveMinvo();
            }
            timeMinvo = 10;
        }
    }

    public void MoveMinvo() {
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

    public void MoveDistanceMinvo() {
        int kt = 0;
        if (kt > 0) {
            AIMedium.oldDistances = AIMedium.distances;
        }
        //kt = 1;
        String next = AIMedium.calculateWay(Bomber.GETX(), Bomber.GETY(), getX(), getY());

        switch (next){
            case "up": {
                moveUp();
                break;
            }
            case "down": {
                moveDown();
                break;
            }
            case "left": {
                moveLeft();
                break;
            }
            case "right": {
                moveRight();
                break;
            }
        }
    }
}

