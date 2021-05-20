package world.keyi.basic.factory.factoryMethod;

import world.keyi.basic.factory.GTA5Game;
import world.keyi.basic.factory.Game;

/**
 * @author 万一
 * @date 2021年05月18日13:29
 */
public class GTA5Factory implements GameAbstractFactory {
    @Override
    public Game getGame() {
        return new GTA5Game();
    }
}
