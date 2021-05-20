package world.keyi.basic.factory.factoryMethod;

import world.keyi.basic.factory.Game;

/**
 * @author 万一
 * @date 2021年05月18日13:31
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        GameAbstractFactory arkFactory = new ARKFactory();
        Game game = arkFactory.getGame();
        game.saying();
    }
}
