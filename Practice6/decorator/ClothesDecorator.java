package world.keyi.basic.decorator;

/**
 * @author 万一
 * @date 2021年05月19日13:19
 */
public class ClothesDecorator extends PersonDecorator {

    private Person personDecorator;
    public ClothesDecorator(Person personDecorator) {
        super(personDecorator);
    }

    @Override
    public void init() {
        super.init();
        getClothes();
    }

    public void getClothes(){
        System.out.println("万一穿上了衣服");
    }
}
