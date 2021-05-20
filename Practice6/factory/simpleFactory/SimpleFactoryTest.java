package world.keyi.basic.factory.simpleFactory;

import world.keyi.basic.factory.ARKGame;
import world.keyi.basic.factory.Game;

/**
 * @author 万一
 * @date 2021年05月18日13:13
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Game game = GameSimpleFactory.getGame(ARKGame.CODE);
        game.saying();
    }
}
