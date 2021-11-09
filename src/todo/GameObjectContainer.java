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

    public void deleteDeadObjects(){
        for(int i = 0;i< GameObject.numObjects;i++){
            if(!gameObjects.get(i).isAlive()){
                gameObjects.get(i).onDelete();
                gameObjects.remove(i);
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

    public void forceAddObject(GameObject o) {
        for(GameObject c:gameObjects){
            if(c.getY() == o.getY())
                c.hp = 0;
        }
        deleteDeadObjects();
        gameObjects.add(o);
    }
}
