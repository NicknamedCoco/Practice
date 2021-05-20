package world.keyi.basic.factory.factoryMethod;

import world.keyi.basic.factory.ARKGame;
import world.keyi.basic.factory.Game;

/**
 * @author 万一
 * @date 2021年05月18日13:30
 */
public class ARKFactory implements GameAbstractFactory {
    @Override
    public Game getGame() {
        return new ARKGame();
    }
}
