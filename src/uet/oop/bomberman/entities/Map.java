package uet.oop.bomberman.entities;

import edu.princeton.cs.algs4.UF;
import uet.oop.bomberman.entities.enemy.*;
import uet.oop.bomberman.entities.move.*;
import uet.oop.bomberman.entities.staticentities.Grass;
import uet.oop.bomberman.entities.staticentities.Portal;
import uet.oop.bomberman.entities.staticentities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Map {
    public int round;
    public int horizontal;
    public int column;
    public ArrayList<ArrayList<Character>> map = new ArrayList<>();
    public List<StaticEntity> nextround = new ArrayList<>();
    public static int[][] diagram = new int[0][0];
    public UF index ;

    public Map() {
        loadFile();
        loadMap();
        index = new UF((horizontal - 2) * (column - 2));
        loadUFMap();
    }

    public void loadFile(){

        File file = new File("res/levels/level1.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        round = scan.nextInt();
        horizontal = scan.nextInt();
        column = scan.nextInt();
        scan.nextLine();
        for(int rowIndex = 0; rowIndex < horizontal; rowIndex++){
            String line = scan.nextLine();
            ArrayList<Character> lineChar = new ArrayList<>();
            for(int colIndex = 0; colIndex < column; colIndex++){
                lineChar.add(line.charAt(colIndex));
            }
            map.add(lineChar);
        }
    }

    public void loadDynamicEntity(List<DynamicEntity> entities){
        for(int rowIndex = 0; rowIndex < map.size(); rowIndex++){
            ArrayList<Character> lineChar = map.get(rowIndex);
            for(int colIndex = 0; colIndex < lineChar.size(); colIndex++){
                DynamicEntity object = null;
                switch (lineChar.get(colIndex)){
                    case '*':{
                        object = new Brick(colIndex, rowIndex,"Brick", Sprite.brick.getFxImage());
                        break;
                    }
                    case 'p':{
                        object = new Bomber(colIndex, rowIndex,"Bomber", Sprite.player_right.getFxImage());
                        break;
                    }
                    case '1':{
                        object = new Balloon(colIndex, rowIndex, "Balloon", Sprite.balloom_right1.getFxImage());
                        break;
                    }
                    case '2':{
                        object = new Oneal(colIndex, rowIndex,"Oneal", Sprite.oneal_right1.getFxImage());
                        break;
                    }
                    case '3':{
                        object = new Doll(colIndex, rowIndex,"Doll", Sprite.doll_right1.getFxImage());
                        break;
                    }
                    case '4':{
                        object = new Minvo(colIndex, rowIndex,"Minvo", Sprite.minvo_right1.getFxImage());
                        break;
                    }
                    case '5':{
                        object = new Kondoria(colIndex, rowIndex,"Kondoria", Sprite.kondoria_right1.getFxImage());
                        break;
                    }
                    case 'b':{
                        object = new BombItem(colIndex, rowIndex,"BombItem", Sprite.powerup_bombs.getFxImage());
                        entities.add(object);
                        object = new Brick(colIndex, rowIndex, "Brick", Sprite.brick.getFxImage());
                        break;
                    }
                    case 'f':{
                        object = new FlameItem(colIndex, rowIndex,"FlameItem", Sprite.powerup_flames.getFxImage());
                        entities.add(object);
                        object = new Brick(colIndex, rowIndex, "Brick", Sprite.brick.getFxImage());
                        break;
                    }
                    case 's':{
                        object = new SpeedItem(colIndex, rowIndex,"SpeedItem", Sprite.powerup_speed.getFxImage());
                        entities.add(object);
                        object = new Brick(colIndex, rowIndex, "Brick", Sprite.brick.getFxImage());
                        break;
                    }
                    case 'x':{
                        object = new Brick(colIndex, rowIndex, "Brick", Sprite.brick.getFxImage());
                        break;
                    }
                    default:{
                        break;
                    }
                }
                if(object != null){
                    entities.add(object);
                }

            }

        }
    }

    public void loadStaticEntity(List<StaticEntity> stillObjects ){
        for(int rowIndex = 0; rowIndex < map.size(); rowIndex++){
            ArrayList<Character> lineChar = map.get(rowIndex);
            for(int colIndex = 0; colIndex < lineChar.size(); colIndex++){
                StaticEntity object = null;
                switch (lineChar.get(colIndex)){
                    case '#':{
                        object = new Wall(colIndex, rowIndex, Sprite.wall.getFxImage());
                        break;
                    }
                    case 'x':{
                        object = new Portal(colIndex, rowIndex, Sprite.portal.getFxImage());
                        StaticEntity portal = new Portal(colIndex, rowIndex, Sprite.portal.getFxImage());
                        nextround.add(portal);
                        break;
                    }
                    default:{
                        object = new Grass(colIndex, rowIndex, Sprite.grass.getFxImage());
                        break;
                    }
                }
                stillObjects.add(object);
            }

        }
    }

    public int[][] loadMap(){
        diagram = new int[horizontal][column];
        for(int rowIndex = 0; rowIndex < map.size(); rowIndex++){
            ArrayList<Character> lineChar = map.get(rowIndex);
            for(int colIndex = 0; colIndex < lineChar.size(); colIndex++){
                switch (lineChar.get(colIndex)){
                    case '#':{    //tuong
                        diagram[rowIndex][colIndex] = -1;
                        break;
                    }
                    case 'x':{   //potal
                        diagram[rowIndex][colIndex] = 2;
                        break;
                    }
                    case '*':{   //gach
                        diagram[rowIndex][colIndex] = 2;
                        break;
                    }
                    case '1':{   //balloon
                        diagram[rowIndex][colIndex] = 0;
                        break;
                    }
                    case '2':{   //oneal
                        diagram[rowIndex][colIndex] = 0;
                        break;
                    }
                    case '3':{   //doll
                        diagram[rowIndex][colIndex] = 0;
                        break;
                    }
                    case '4':{   //minvo
                        diagram[rowIndex][colIndex] = 0;
                        break;
                    }
                    case '5':{   //kondoria
                        diagram[rowIndex][colIndex] = 0;
                        break;
                    }
                    case 'b':{   // boomitem
                         diagram[rowIndex][colIndex] = 3;
                        break;
                    }
                    case 'f':{   //flame
                        diagram[rowIndex][colIndex] = 3;
                        break;
                    }
                    case 's':{   //speed
                        diagram[rowIndex][colIndex] = 3;
                        break;
                    }
                    default:{
                        diagram[rowIndex][colIndex] = 0;
                        break;
                    }
                }
            }
        }
        return diagram;
    }

    public void loadUFMap(){
        for(int i = 1; i < horizontal - 1; i++){
            for(int j = 1; j < column - 1; j++){
                if(diagram[i][j] == 0){
                    if(diagram[i][j+1] == 0){
                        index.union(UFvalue(i,j), UFvalue(i, j+1));
                    }
                    if(diagram[i+1][j] == 0){
                        index.union(UFvalue(i,j), UFvalue(i+1, j));
                    }
                }
            }
        }
    }

    public int UFvalue(int x, int y){
        return (x - 1) * (column - 2) + y - 1;
    }
}
