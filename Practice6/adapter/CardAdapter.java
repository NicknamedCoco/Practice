package world.keyi.basic.adapter;

/**
 * @author 万一
 * @date 2021年05月18日18:13
 */
public class CardAdapter implements Card {
    TFCard tfCard;

    public CardAdapter(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public void read() {
        tfCard.readTFCard();
    }

    @Override
    public void write() {
        tfCard.writeTFCard();
    }
}
