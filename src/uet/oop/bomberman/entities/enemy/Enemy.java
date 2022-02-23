package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.DynamicEntity;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Enemy extends DynamicEntity {
    public Audio meme = new Audio(1000);
    protected static final int DEFAULT_SIZE = 16;
    protected static final int SCALED_SIZE = DEFAULT_SIZE * 2;

    /**
     * author me.
     * @param xUnit xUnit coordinate
     * @param yUnit yUnit coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public Enemy(int xUnit, int yUnit, String name, Image img) {
        super(xUnit, yUnit, name, img);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void animate() {
        if(timeGame == 59) {
            Audio.playEntinyDie();
        } else {
            if (timeGame >= 40) {
                img = Sprite.mob_dead1.getFxImage();
            } else {
                if (timeGame >= 20) {
                    img = Sprite.mob_dead2.getFxImage();
                } else {
                    if (timeGame > 1) {
                        img = Sprite.mob_dead3.getFxImage();
                    }
                }
            }
        }

    }
    protected int hardsize = SCALE_SIZE / 2;
    @Override
    public void remove() {
        if(blood == 0){
            BombermanGame.MapgameLoad.diagram[getY()][getX()] = 0;
            die = true;
        }
        else blood--;
    }

    public void moveUp() {
        if(!checkDead) {
            if (BombermanGame.MapgameLoad.diagram[getY() - 1][getX()] == 0
                    || BombermanGame.MapgameLoad.diagram[getY() - 1][getX()] == 1) {
                x = getX() * SCALE_SIZE;
                y -= hardsize / 2;
            }
            else if(y % SCALE_SIZE != 0){
                y = getY() * SCALE_SIZE;
            }
        }
    }

    public void moveDown() {
        if (!checkDead) {
            if(BombermanGame.MapgameLoad.diagram[getY() + 1][getX()] == 0
                    || BombermanGame.MapgameLoad.diagram[getY() + 1][getX()] == 1) {
                x = getX() * SCALE_SIZE;
                y += hardsize / 2;
            }
            else if(y % SCALE_SIZE != 0){
                y = getY() * SCALE_SIZE;
            }
        }
    }

    public void moveLeft() {
        if (!checkDead) {
            if(BombermanGame.MapgameLoad.diagram[getY()][getX() - 1] == 0
                    || BombermanGame.MapgameLoad.diagram[getY()][getX() - 1] == 1) {
                y = getY() * SCALE_SIZE;
                x -= hardsize / 2;
            }
            else if(x % SCALE_SIZE != 0){
                x = getX() * SCALE_SIZE;
            }
        }
    }

    public void moveRight(){
        if (!checkDead) {
            if(BombermanGame.MapgameLoad.diagram[getY()][getX() + 1] == 0 || BombermanGame.MapgameLoad.diagram[getY()][getX() + 1] == 1){
                y = getY() * SCALE_SIZE;
                x += hardsize / 2;
            }
            else if(x % SCALE_SIZE != 0){
                x = getX() * SCALE_SIZE;
            }
        }
    }

    @Override
    public int getX() {
        return (int) (x / SCALED_SIZE);
    }

    @Override
    public int getY() {
        return  (int) (y / SCALED_SIZE);
    }


}
