package world.keyi.basic.adapter;

/**
 * @author 万一
 * @date 2021年05月18日18:08
 */
public class AdapterTest {
    public static void main(String[] args) {
        TFCard tfCard = new TFCardImpl();
        CardAdapter cardAdapter = new CardAdapter(tfCard);
        Computer lenovoComputer = new LenovoComputer();
        lenovoComputer.readCard(cardAdapter);
        lenovoComputer.writeCard(cardAdapter);
    }
}
