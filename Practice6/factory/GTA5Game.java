package world.keyi.basic.factory;

/**
 * @author 万一
 * @date 2021年05月18日12:57
 */
public class GTA5Game implements Game {

    public static final String CODE="GTA5";

    @Override
    public void saying() {
        System.out.println("GTA5真好玩。。。。。");
    }
}
