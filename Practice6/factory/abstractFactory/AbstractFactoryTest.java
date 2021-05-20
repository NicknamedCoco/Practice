package world.keyi.basic.factory.abstractFactory;

/**
 * @author 万一
 * @date 2021年05月18日14:37
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory gta5Factory = new GTA5Factory();
        gta5Factory.getGame().saying();
        gta5Factory.getVideo().show();
    }
}
