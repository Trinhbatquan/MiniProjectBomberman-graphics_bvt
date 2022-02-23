package uet.oop.bomberman.entities.bomb;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;


public class Flames extends Flame {
    public int index;
    public int timeFlame = 180;
    List<Flame> flameone = new ArrayList<>();
    List<Flame> flametwo = new ArrayList<>();
    List<Flame> flamethree = new ArrayList<>();

    /**
     * author me.
     * @param UnitX UnitX coordinate
     * @param UnitY UnitY coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public Flames(int UnitX, int UnitY, String name, Image img) {
        super(UnitX, UnitY, name, img);
    }

    public Flames(int UnitX, int UnitY, int index) {
        this.x = UnitX * Sprite.SCALED_SIZE;
        this.y = UnitY * Sprite.SCALED_SIZE;
        this.index = index;
        createFlameGame();
    }

    // add Flame.
    public void createFlameGame(){
        Flame center = new Flame(getX(), getY(), "center", Sprite.bomb_exploded.getFxImage());
        flameone.add(center);
        Flame center1 = new Flame(getX(), getY(), "Flame", Sprite.bomb_exploded1.getFxImage());
        flametwo.add(center1);
        Flame center2 = new Flame(getX(), getY(), "Flame", Sprite.bomb_exploded2.getFxImage());
        flamethree.add(center2);

        for(int i = 1; i <= index; i++){
            if(BombermanGame.MapgameLoad.diagram[getY() - i][getX()] != 0 || i == index){
                Flame top = new Flame(getX(), getY() - i, "top", Sprite.explosion_vertical_top_last.getFxImage());
                flameone.add(top);
                Flame top1 = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical_top_last1.getFxImage());
                flametwo.add(top1);
                Flame top2 = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical_top_last2.getFxImage());
                flamethree.add(top2);
                break;
            }
            else{
                Flame top = new Flame(getX(), getY() - i, "top", Sprite.explosion_vertical.getFxImage());
                flameone.add(top);
                Flame top1 = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical1.getFxImage());
                flametwo.add(top1);
                Flame top2 = new Flame(getX(), getY() - i, "Flame", Sprite.explosion_vertical2.getFxImage());
                flamethree.add(top2);
            }
        }
        for(int i = 1; i <= index; i++){
            if(BombermanGame.MapgameLoad.diagram[getY() + i][getX()] != 0 || i == index){
                Flame down = new Flame(getX(), getY() + i, "down", Sprite.explosion_vertical_down_last.getFxImage());
                flameone.add(down);
                Flame down1 = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical_down_last1.getFxImage());
                flametwo.add(down1);
                Flame down2 = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical_down_last2.getFxImage());
                flamethree.add(down2);
                break;
            }
            else{
                Flame down = new Flame(getX(), getY() + i, "down", Sprite.explosion_vertical.getFxImage());
                flameone.add(down);
                Flame down1 = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical1.getFxImage());
                flametwo.add(down1);
                Flame down2 = new Flame(getX(), getY() + i, "Flame", Sprite.explosion_vertical2.getFxImage());
                flamethree.add(down2);
            }
        }
        for(int i = 1; i <= index; i++){
            if(BombermanGame.MapgameLoad.diagram[getY()][getX() - i] != 0 || i == index){
                Flame left = new Flame(getX() - i, getY(), "left", Sprite.explosion_horizontal_left_last.getFxImage());
                flameone.add(left);
                Flame left1 = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal_left_last1.getFxImage());
                flametwo.add(left1);
                Flame left2 = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal_left_last2.getFxImage());
                flamethree.add(left2);
                break;
            }
            else{
                Flame left = new Flame(getX() - i, getY(), "left", Sprite.explosion_horizontal.getFxImage());
                flameone.add(left);
                Flame left1 = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal1.getFxImage());
                flametwo.add(left1);
                Flame left2 = new Flame(getX() - i, getY(), "Flame", Sprite.explosion_horizontal2.getFxImage());
                flamethree.add(left2);
            }
        }
        for(int i = 1; i <= index; i++){
            if(BombermanGame.MapgameLoad.diagram[getY()][getX() + i] != 0 || i == index){
                Flame right = new Flame(getX() + i, getY(), "right", Sprite.explosion_horizontal_right_last.getFxImage());
                flameone.add(right);
                Flame right1 = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal_right_last1.getFxImage());
                flametwo.add(right1);
                Flame right2 = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal_right_last2.getFxImage());
                flamethree.add(right2);
                break;
            }
            else{
                Flame right = new Flame(getX() + i, getY(), "right", Sprite.explosion_horizontal.getFxImage());
                flameone.add(right);
                Flame right1 = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal1.getFxImage());
                flametwo.add(right1);
                Flame right2 = new Flame(getX() + i, getY(), "Flame", Sprite.explosion_horizontal2.getFxImage());
                flamethree.add(right2);
            }
        }
    }

    // anamate Flame
    public void render(GraphicsContext gc) {
        System.out.println("aaaaa");
        if(timeFlame <=60 && timeGame >=40) {
            flameone.forEach(flameOption1 -> {
                flameOption1.render(gc);
            });
        } else
            if (timeFlame < 40 && timeFlame > 20) {
                flametwo.forEach(flameOption1 -> {
                    flameOption1.render(gc);
                });
            }
         else {
            if (timeFlame <= 20 && timeFlame >= 1) {
                flamethree.forEach(flameOption2 -> {
                    flameOption2.render(gc);
                });
            }
        }
        }

        @Override
    public void update() {
        if (timeFlame == 60) {
            KillEntityInBomb();
        }  else {
            if (timeFlame == 0) {
                remove();   // remove hình ảnh
            }
        }
        timeFlame--;
    }

    @Override
    public void animate() {

    }

    @Override
    public void remove() {
      die = true;
    }

    // va cham với flame = die
    public void KillEntityInBomb(){
        BombermanGame.dynamicEntities.forEach(entity -> {
            if(EntityDieInBomb(entity.getX(), entity.getY())){
                if(entity.isSymbol()){
                    entity.remove();
                }
                else {
                    entity.checkDead();
                }

                if (entity.getName().equals("Bomber")) {
                    Audio.playEntinyDie();
                }
            }
        });
        BombermanGame.MapgameLoad.loadUFMap();


            }

            public boolean EntityDieInBomb(int xUnit, int yUnit){
        for(int i = 0; i < flameone.size(); i++){
            Flame flame = flameone.get(i);
            if(flame.getX() == xUnit && flame.getY() == yUnit) {
                return true;
            }
        }
        return false;
    }
}
