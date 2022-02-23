package uet.oop.bomberman;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.scene.Parent;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.Flames;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.Map;
import uet.oop.bomberman.entities.move.Bomber;
import uet.oop.bomberman.entities.StaticEntity;
import uet.oop.bomberman.entities.DynamicEntity;
import uet.oop.bomberman.graphics.Sprite;
import java.util.ArrayList;
import java.util.List;
import uet.oop.bomberman.audio.*;

import javax.print.DocFlavor;

public class BombermanGame extends Application implements Initializable {

    public static int WIDTH;
    public static int HEIGHT;
    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Bomb> bombs = new ArrayList<>();
    public static List<DynamicEntity> dynamicEntities = new ArrayList<>();
    public static List<Bomber> bomberList = new ArrayList<>();
    public static List<Flames> flameList = new ArrayList<>();
    public  List<StaticEntity> staticEntities = new ArrayList<>();
    private Bomber person = null;
    public boolean Dead = true;
    private int timeGame = 60;
    public Audio audio = new Audio(999);
    public static Map MapgameLoad = new Map();

    public static Stage primanyScholl = null;
    public Button startGame;
    public Button musicGame;
    public Button quizGame;


   Parent root = null;




    public static void main(String[] args) {
        Application.launch(BombermanGame.class);


    }

    @Override
    public void initialize(URL location, ResourceBundle libarary) {
        System.out.println("o");
        String url ="src/uet/oop/bomberman/background.fxml";
        try {
            InputStream fxmlStream = new FileInputStream(url);
            root = (new FXMLLoader()).load(fxmlStream);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override
    public void start (Stage primanyScholl) {


        Scene scene = new Scene(root);
        primanyScholl.setScene(scene);
        primanyScholl.setResizable(false);
        primanyScholl.show();

    }


    public void startGameButton(ActionEvent event) {
        WIDTH = MapgameLoad.column;
        HEIGHT = MapgameLoad.horizontal;
        audio.playMeme();
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();
        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        primanyScholl.setScene(scene);
        primanyScholl.show();

        //load Map
        MapgameLoad.loadDynamicEntity(dynamicEntities);
        MapgameLoad.loadStaticEntity(staticEntities);
        ContentGame();
        person =(Bomber) dynamicEntities.get(0);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                person.MoveBomber(event);
            }
        });
    }

    public void musicGameButton(ActionEvent event) {

    }

    public void quizGameButton(ActionEvent event) {

    }

    public void update() {
        for(int i=0; i < bombs.size(); i++)
        {
            bombs.get(i).update();
        }
        dynamicEntities.forEach(entityOption -> {
            entityOption.update();
            switch (entityOption.getName()) {
                case "Balloon":{
                    if(entityOption.toString().equals(person.toString())) {
                        person.checkDead();
                    }
                    break;
                }
                case "Minvo":{
                    if(entityOption.toString().equals(person.toString())){
                        person.checkDead();
                    }
                    break;
                }
                case "Kondoria":{
                    if(entityOption.toString().equals(person.toString())){
                        person.checkDead();
                    }
                    break;
                }
                case "Doll":{
                    if(entityOption.toString().equals(person.toString())){
                        person.checkDead();
                    }
                    break;
                }
                case "BombItem":{
                    if(entityOption.toString().equals(person.toString())){
                        entityOption.remove();
                        Audio.EntityEat();
                        person.plusBomb();
                    }
                    break;
                }
                case "FlameItem":{
                    if(entityOption.toString().equals(person.toString())){
                        entityOption.remove();
                        Audio.EntityEat();
                        person.plusFlame();
                    }
                    break;
                }
                case "SpeedItem":{
                    if(entityOption.toString().equals(person.toString())){
                        entityOption.remove();
                        Audio.EntityEat();
                        person.plusSpeed();
                    }
                    break;
                }
            }


        });

        flameList.forEach(flameOption -> {
            flameOption.update();
        });
        flameList.removeIf(flameOption ->{
            return flameOption.isDie();
        });
        bombs.removeIf(flameOption ->{    // remove tọa độ
            return flameOption.isDie();
        });

        dynamicEntities.removeIf(entityOption -> {
            return entityOption.isDie();
        });

        MapgameLoad.nextround.forEach(portal -> {
            if(portal.toString().equals(person.toString())){
                boolean enemyInMap = true;
                for(int i = 0; i < dynamicEntities.size(); i++){
                    if(dynamicEntities.get(i).getName().equals("Balloon") || dynamicEntities.get(i).getName().equals("Oneal")
                            || dynamicEntities.get(i).getName().equals("Doll") || dynamicEntities.get(i).getName().equals("Minvo")
                            || dynamicEntities.get(i).getName().equals("Kondoria")){
                        enemyInMap = false;
                    }
                }
                if(enemyInMap) {
                    Dead = false;
                    Audio.playWin();
                    gameOver("Victory");
                }
            }
        });
    }

    public void render() {
        bomberList.forEach(e -> e.render(gc));
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        staticEntities.forEach(g -> g.render(gc));
        dynamicEntities.forEach(g -> g.render(gc));
        flameList.forEach(g -> g.render(gc));
        bombs.forEach(e -> e.render(gc));

    }

    public void gameOver(String text){
        if(Dead) {
            person.animate();
            audio.stopGame();
        }
        timer.stop();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(100));
        gc.setStroke(Color.WHITE);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText( text , canvas.getWidth() / 2, canvas.getHeight() / 2);
    }

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if(person.isDie()) {
                if(timeGame == 0){
                    gameOver("Defeat");
                }
                else {
                    render();
                    update();
                    timeGame--;
                }
            }
            else {
                render();
                update();
            }
        }
    };

    public void ContentGame(){
        timer.start();
    }

    public void nextMap() {
    // chưa cần
    }
}
