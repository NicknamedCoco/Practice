package world.keyi.basic.decorator;

/**
 * @author 万一
 * @date 2021年05月19日13:15
 */
public abstract class PersonDecorator implements Person {
    private Person personDecorator;

    public PersonDecorator(Person personDecorator) {
        this.personDecorator = personDecorator;
    }

    @Override
    public void init() {
        personDecorator.init();
    }
}
