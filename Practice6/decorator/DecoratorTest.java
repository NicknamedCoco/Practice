package world.keyi.basic.decorator;

/**
 * @author 万一
 * @date 2021年05月19日14:04
 */
public class DecoratorTest {
    public static void main(String[] args) {
        ClothesDecorator clothesDecorator = new ClothesDecorator(new Wanyi());
        clothesDecorator.init();
    }
}
