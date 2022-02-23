package uet.oop.bomberman.entities.enemy.Items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.StaticEntity;

/**
 * Created by DatHoang on 2/26/2021.
 */
public class Item extends StaticEntity {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item(int x, int y, Image img, String type) {
        super(x, y, img);
        this.type = type;
    }

    @Override
    public void update()
    {

    }
}
