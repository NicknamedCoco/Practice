package world.keyi.basic.factory.abstractFactory;

import world.keyi.basic.factory.Game;
import world.keyi.basic.factory.Video;

public interface AbstractFactory {
    Video getVideo();
    Game getGame();
}
