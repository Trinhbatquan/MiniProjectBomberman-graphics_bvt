package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.DynamicEntity;


public class Flame extends DynamicEntity {

    /**
     * author me.
     * @param UnitX UnitX coordinate
     * @param UnitY UnitY coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public Flame(int UnitX, int UnitY, String name, Image img) {
        super(UnitX, UnitY, name, img);
    }

    public Flame() {
      super();
    }
    @Override
    public void remove() {
     die = true;
    }

    @Override
    public void animate() {

    }

    @Override
    public void update() {
       super.update();
    }
}







