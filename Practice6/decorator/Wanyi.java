package world.keyi.basic.decorator;

/**
 * @author 万一
 * @date 2021年05月19日13:13
 */
public class Wanyi implements Person {

    @Override
    public void init() {
        System.out.println("万一洗完澡了，但是没有衣服穿");
    }
}
