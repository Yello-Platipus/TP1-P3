package es.ucm.tp1.supercars.view;

import es.ucm.tp1.supercars.logic.Game;

public class GameSerializer {

    private final String HEADER = "---- ROAD FIGHTER SERIALIZED ----\n";

    protected Game game;

    public GameSerializer(Game game) {
        this.game = game;
    }

    public String getTime(){
        String ret = "";

        if(game.getCycles() == 0)
            ret = "\n"+ "EllapsedTime: 0"; // Elapsed*
        else
            ret = ("\n"+ "EllapsedTime:" + ((double)System.currentTimeMillis() - game.getStartTime()) / 1000) + " s";

        return ret;
    }

    public String serialize(){
        StringBuilder sb = new StringBuilder(HEADER);
        sb.append("Level: " + game.getLevel().toString() + "\n");
        sb.append("Cycles: " + game.getCycles() + "\n");
        sb.append("Coins: " + game.getNumCoins());
        if(!game.getModoTest())
            sb.append(getTime());
        sb.append("\n"+"Game Objects: \n");
        sb.append(containerSerialization() + "\n");
        return sb.toString();
    }

    public String containerSerialization(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < game.getLength(); i++)
            for(int j = 0; j < game.getWidth(); j++)
                builder.append(game.serializePosition(i, j));
        return builder.toString().trim();
    }

}
