package world.keyi.basic.factory;

/**
 * @author 万一
 * @date 2021年05月18日13:00
 */
public class ARKGame implements Game {
    public static final String CODE = "ARK";

    @Override
    public void saying() {
        System.out.println("方舟真好玩。。。。。");
    }
}
