package world.keyi.basic.factory.simpleFactory;

import world.keyi.basic.factory.ARKGame;
import world.keyi.basic.factory.GTA5Game;
import world.keyi.basic.factory.Game;

/**
 * @author 万一
 * @date 2021年05月18日13:01
 */
public class GameSimpleFactory {

    public static Game getGame(String code){
        Game game=null;
        if (code.equalsIgnoreCase("GTA5")){
            game=new GTA5Game();
        }else if (code.equalsIgnoreCase("ARK")){
            game=new ARKGame();
        }
        return game;
    }
}
