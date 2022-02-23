package uet.oop.bomberman.entities.move;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.DynamicEntity;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends DynamicEntity {

    /**
     * author me.
     * @param x x coordinate
     * @param y y coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public Brick(int x, int y, String name, Image img) {
        super(x, y, name, img);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void remove() {
        BombermanGame.MapgameLoad.diagram[getY()][getX()] -= 2;
        die = true;
    }

    @Override
    public void animate(){
        img = Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, timeGame, 60).getFxImage();
    }
}
