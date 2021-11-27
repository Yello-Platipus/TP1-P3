package todo;

import java.util.ArrayList;

public class GameObjectContainer {
    private ArrayList <GameObject> gameObjects;

    public GameObjectContainer() {
        gameObjects = new ArrayList <GameObject>();
        GameObject.numObjects = 0;
    }

    public void addObject(GameObject object){
        if(getObjectInPos(object.getX(),object.getY()) == null){
            gameObjects.add(object);
            object.onEnter();
        }
    }

    public void updateObjects(){
        int i = gameObjects.size() - 1;
        while(i >= 0){
            gameObjects.get(i).update();
            i--;
        }
    }

    public void deleteDeadObjects(){
        int i = gameObjects.size() - 1;
        while(i >= 0){
            if(!gameObjects.get(i).isAlive()){
                gameObjects.get(i).onDelete();
                gameObjects.remove(i);
            }
            i--;
        }
    }

    public GameObject getObjectInPos(int x, int y){
        GameObject ret = null;
        int i = 0;
        while(i < GameObject.getNumObjects() && ret == null){
            if(gameObjects.get(i).isInPosition(x, y))
                ret = gameObjects.get(i);
            else
                i++;
        }
        return ret;
    }

    public void clearRow(int row) {
        for(GameObject c:gameObjects){
            if(c.getX() == row)
                c.hp = 0;
        }
    }

    public void clear() {
        for(GameObject c: gameObjects){
            c.hp = 0;
        }
        deleteDeadObjects();
    }

    public String getStringInPos(int x, int y){
        StringBuilder objects = new StringBuilder();
        for(GameObject c: gameObjects)
            if(c.isInPosition(x, y))
                objects.append(c.getSymbol() + " ");
        return objects.toString().trim();
    }
}
