package uet.oop.bomberman.entities.ai;
import java.util.ArrayList;
import uet.oop.bomberman.BombermanGame;


public class AIMedium extends AI{
    @Override
    public int calculateDirection() {
        return 0;
    }

    public static ArrayList<Distance> distances = null;
    public static class Distance {
        String next;
        double distance;

        Distance(String next, double distance) {
            this.next = next;
            this.distance = distance;
        }

        Distance(Distance x){
            this.next = x.getNext();
            setDistance(x.getDistance());
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }
    }

    public static ArrayList<Distance> oldDistances = new ArrayList<>();
    public static int i = 0;

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static String calculateWay(int playerX, int playerY, int enemyX, int enemyY) {
        distances = new ArrayList<>();

        double up = distance(playerX, playerY, enemyX, enemyY - 1);
        double down = distance(playerX, playerY, enemyX, enemyY + 1);
        double left = distance(playerX, playerY, enemyX - 1, enemyY);
        double right = distance(playerX, playerY, enemyX + 1, enemyY);

        Distance up1 = new Distance("up", up);
        Distance down1 = new Distance("down", down);
        Distance left1 = new Distance("left", left);
        Distance right1 = new Distance("right", right);
        distances.add(up1);
        distances.add(down1);
        distances.add(left1);
        distances.add(right1);

        //sap xep list
        for(int  i = 0; i < 4; i++){
            double min = distances.get(i).getDistance();
            int index = i;
            for (int j = i; j < 4; j++){
                if(min > distances.get(j).getDistance()){
                    min = distances.get(j).getDistance();
                    index = j;
                }
            }
            Distance temp = new Distance(distances.get(i));
            distances.set(i, distances.get(index));
            distances.set(index, temp);
        }

        if ( i >= 3 && oldDistances.equals(distances)) {
            distances.remove(0);
            return canMove(distances, enemyX, enemyY);
        }
        else {
            return canMove(distances, enemyX, enemyY);
        }
    }

    public static String canMove(ArrayList<Distance> distances, int enemyX, int enemyY){
        boolean canMove = false;
        String next = "";
        i = 0;


        do{
            next = distances.get(i).getNext();
            switch (next){
                case "up" :{
                    if(BombermanGame.MapgameLoad.diagram[enemyY - 1][enemyX] != 0){
                        i++;
                    }
                    else canMove = true;
                    break;
                }
                case "down" :{
                    if(BombermanGame.MapgameLoad.diagram[enemyY + 1][enemyX] != 0){
                        i++;
                    }
                    else canMove = true;
                    break;
                }
                case "left" :{
                    if(BombermanGame.MapgameLoad.diagram[enemyY][enemyX - 1] != 0){
                        i++;
                    }
                    else canMove = true;
                    break;
                }
                case "right" :{
                    if(BombermanGame.MapgameLoad.diagram[enemyY][enemyX + 1] != 0){
                        i++;
                    }
                    else canMove = true;
                    break;
                }
            }
        }
        while (!canMove && i < 4);
        return next;
    }

    }
