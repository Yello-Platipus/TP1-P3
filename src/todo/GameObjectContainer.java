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
        int i = 0;
        while(i< GameObject.numObjects){
            if(!gameObjects.get(i).isAlive()){
                gameObjects.get(i).onDelete();
                gameObjects.remove(i);
            }
            else {
                gameObjects.get(i).update();
                i++;
            }
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
        updateObjects();
    }

    public void pushSeenObjects(int startColumn, int endColumn){
        for(int i = GameObject.getNumObjects() - 1; i >= 0; i--){
            GameObject o = gameObjects.get(i);
            if(o.getX() >= startColumn && o.getX() <= endColumn && getObjectInPos(o.getX() + 1, o.getY()) == null){
                o.x++;
                gameObjects.set(i, o);
            }
        }
    }

    public String getStringInPos(int x, int y){
        StringBuilder objects = new StringBuilder();
        for(GameObject c: gameObjects)
            if(c.isInPosition(x, y))
                objects.append(c.getSymbol() + " ");
        return objects.toString().trim();
    }
}
