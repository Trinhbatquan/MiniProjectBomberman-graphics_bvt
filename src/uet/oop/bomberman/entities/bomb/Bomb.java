package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.DynamicEntity;
import uet.oop.bomberman.entities.move.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class Bomb extends DynamicEntity {
    int timeBomb = 180;
    public int Limitflame = Bomber.setTimePlusFlame();

    public Bomb(int UnitX, int UnitY, String name, Image img) {
        super(UnitX, UnitY, name, img);
        BombermanGame.MapgameLoad.diagram[getY()][getX()] = 2;
        Flames flamebuff = new Flames(getX(), getY(), Limitflame);
        BombermanGame.flameList.add(flamebuff);      // add các loại Flames vào List
    }

    public void update() {
        animate();
        if (timeBomb == 60) {
            voiceBomb();
            remove();
        } else {
            if (timeBomb == 0) {
                remove();
            }
        }
        timeBomb--;
    }

    @Override
    public void animate() {
        if (timeBomb < 180 && timeBomb >= 150) {
            img = Sprite.bomb_2.getFxImage();
        } else {
            if (timeBomb > 100) {
                img = Sprite.bomb_1.getFxImage();
            } else {
                if (timeBomb > 60) {
                    img = Sprite.bomb.getFxImage();
                }
            }
        }
    }

    public void voiceBomb() {
        if (timeBomb == 60) {
            Audio.playBombExplode();}
    }

    @Override
    public void remove() {
        BombermanGame.MapgameLoad.diagram[getY()][getX()] = 0;
        Bomber.limitBomb++;
        die = true;
    }
}

