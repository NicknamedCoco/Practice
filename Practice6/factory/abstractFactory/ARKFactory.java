package world.keyi.basic.factory.abstractFactory;

import world.keyi.basic.factory.ARKVideo;
import world.keyi.basic.factory.GTA5Game;
import world.keyi.basic.factory.Game;
import world.keyi.basic.factory.Video;

/**
 * @author 万一
 * @date 2021年05月18日14:31
 */
public class ARKFactory implements AbstractFactory {
    @Override
    public Video getVideo() {
        return new ARKVideo();
    }

    @Override
    public Game getGame() {
        return new GTA5Game();
    }
}
