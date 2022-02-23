package uet.oop.bomberman.entities.move;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.DynamicEntity;

public class BombItem extends DynamicEntity {
    BombItem BIiem;

    /**
     * author me.
     * @param xUnit xUnit coordinate
     * @param yUnit yUnit coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public BombItem(int xUnit, int yUnit, String name, Image img) {
        super(xUnit, yUnit, name, img);
        blood = 1;
        symbol = true;
    }

    @Override
    public void update() {
    }

    @Override
    public void animate() {
    }

    public void remove() {
        if(blood == 0){
            BombermanGame.MapgameLoad.diagram[getY()][getX()] = 0;
            die = true;
        }
        else blood -= 1;
    }
}
