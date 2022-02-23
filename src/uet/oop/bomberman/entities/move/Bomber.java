package uet.oop.bomberman.entities.move;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.DynamicEntity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends DynamicEntity {
    public Audio voice = new Audio(1000);
    public static int X;
    public static int Y;
    Bomb bomb;
    private int power;
    public void setPower(int power) {
        this.power = power;
    }
    public int getPower() {
        return power;
    }
    protected int Timelive = 0;
    public int setup_Size = SCALE_SIZE / 2;

    public static int limitBomb = 1;
    public static int limitflame = 1;
    public static int limitspeed = 1;
    public static int  timePlusBomb = 300;
    public static int  timePlusFlame = 300;
    public static int  timePlusSpeed = 300;


    /**
     * author me.
     * @param x x coordinate
     * @param y y coordinate
     * @param name name coordinate
     * @param img img coordinate
     */
    public Bomber(int x, int y, String name, Image img) {
        super(x, y, name, img);
    }

    @Override
    public void update() {
        super.update();
        X = getX();
        Y = getY();
        Timelive++;
        if (limitBomb > 1 && timePlusBomb > 0) {
            timePlusBomb--;
      }
        if (limitflame > 1 && timePlusFlame > 0) {
            timePlusFlame--;
      }

        if (limitspeed > 1 &&  timePlusSpeed > 0) {
            timePlusSpeed --;
        }
        System.out.println("test: " +  timePlusBomb);
    }

    // chạy nhanh
    public void plusSpeed(){
      if (setup_Size < SCALE_SIZE) {
          setup_Size += SCALE_SIZE / 4;
      } else {
          setup_Size = SCALE_SIZE;
      }
      limitspeed += 1;
    }

    // tăng Flame bom
    public void plusFlame() {
        limitflame += 1;
    }

    // Tăng số lượng bom
    public void plusBomb() {
        limitBomb += 1;

    }

    public static int setTimePlusFlame() {
        if (timePlusFlame == 0) {
            limitflame = 1;
        }
        return limitflame;
    }

    public  int setTimePlusSpeed() {
        if ( timePlusSpeed == 0) {
            limitspeed = 1;
            setup_Size  = SCALE_SIZE / 2;
        }
        return setup_Size;
    }

    public void MoveBomber(KeyEvent keyEvent)
        {
            KeyCode keyCode = keyEvent.getCode();
            if(keyCode==KeyCode.W||keyCode==KeyCode.UP)
            {
                moveUp();
            }
            else if(keyCode==KeyCode.A||keyCode==KeyCode.LEFT)
            {
                moveLeft();
            }
            else if(keyCode==KeyCode.D||keyCode==KeyCode.RIGHT)
            {
                moveRight();
            }
            else if(keyCode==KeyCode.S||keyCode==KeyCode.DOWN)
            {
                moveDown();
            }
            else if(keyCode==KeyCode.SPACE) {
                placeBomb();
            }
        }

    private void placeBomb() {
        if (limitBomb > 0 ) {
            if (timePlusBomb == 0) {
                limitBomb = 1;
            }
            bomb = new Bomb(getX(), getY(), "Bomb", Sprite.bomb.getFxImage());
            BombermanGame.bombs.add(bomb);
            Audio.playBombDrop();
            limitBomb--;
        }

    }

    private void moveDown() {
        img = Sprite.movingSprite(Sprite.player_down,
                Sprite.player_down_1, Sprite.player_down_2, Timelive, 20).getFxImage();
        if (BombermanGame.MapgameLoad.diagram[getY() + 1][getX()] == 0 || BombermanGame.MapgameLoad.diagram[getY() + 1][getX()] == 1) {
            x = getX() * SCALE_SIZE;
            int value = setTimePlusSpeed();
            y += value;
        }
        else if(y % SCALE_SIZE != 0){
            y = getY() * SCALE_SIZE;
        }
        Audio.playBomberWalk();
    }

    private void moveRight() {
        img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, Timelive, 20).getFxImage();
        if(BombermanGame.MapgameLoad.diagram[getY()][getX() + 1] == 0 || BombermanGame.MapgameLoad.diagram[getY()][getX() + 1] == 1){
            y = getY() * SCALE_SIZE;
            int value1 = setTimePlusSpeed();
            x += value1;
        }
        else if(x % SCALE_SIZE != 0){
            x = getX() * SCALE_SIZE;
        }
        Audio.playBomberWalk();
    }

    private void moveLeft() {
        img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, Timelive, 20).getFxImage();

        if(BombermanGame.MapgameLoad.diagram[getY()][getX() - 1] == 0 || BombermanGame.MapgameLoad.diagram[getY()][getX() - 1] == 1) {
            y = getY() * SCALE_SIZE;
            int value2 = setTimePlusSpeed();
            x -= value2;
        }
        else if(x % SCALE_SIZE != 0){
            x = getX() * SCALE_SIZE;
        }
        Audio.playBomberWalk();
    }

    private void moveUp() {
        img = Sprite.movingSprite(Sprite.player_up,
                Sprite.player_up_1, Sprite.player_up_2, Timelive, 20).getFxImage();
        if (BombermanGame.MapgameLoad.diagram[getY() - 1][getX()] == 0 || BombermanGame.MapgameLoad.diagram[getY() - 1][getX()] == 1) {
            x = getX() * SCALE_SIZE;
            int value3 = setTimePlusSpeed();
            y -= value3;
        } else {
            if (y % SCALE_SIZE != 0) {
                y = getY() * SCALE_SIZE;
            }
        }
        Audio.playBomberWalk();
    }

    @Override
    public int getX() {
        return (int) (x / SCALE_SIZE);
    }

    @Override
    public int getY() {
        return  (int) (y / SCALE_SIZE);
    }

    @Override
    public void remove() {
        die = true;
    }

    @Override
    public void animate() {
        img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, timeGame, 60).getFxImage();
    }

    public static int GETX(){
        return X;
    }
    public static int GETY(){
        return Y;
    }

}
