package world.keyi.basic.adapter;

/**
 * @author 万一
 * @date 2021年05月18日18:05
 */
public class LenovoComputer implements Computer {

    @Override
    public void readCard(Card card) {
        card.read();
    }

    @Override
    public void writeCard(Card card) {
        card.write();
    }
}
