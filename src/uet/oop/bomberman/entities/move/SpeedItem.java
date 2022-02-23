package uet.oop.bomberman.entities.move;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.DynamicEntity;

public class SpeedItem extends DynamicEntity {

    /**
     * author me.
     * @param xUnit xUnit coordinate
     * @param yUnit yUnit coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public SpeedItem(int xUnit, int yUnit, String name, Image img) {
        super(xUnit, yUnit, name, img);
        symbol = true;
        blood = 1;
    }

    @Override
    public void update() {

    }

    @Override
    public void animate() {

    }

    @Override
    public void remove() {
        if(blood == 0){
            BombermanGame.MapgameLoad.diagram[getY()][getX()] = 0;
            die = true;
        }
        else blood -= 1;
    }
}
