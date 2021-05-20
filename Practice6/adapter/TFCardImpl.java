package world.keyi.basic.adapter;

/**
 * @author 万一
 * @date 2021年05月18日18:11
 */
public class TFCardImpl implements TFCard {
    @Override
    public void readTFCard() {
        System.out.println("读取TF卡中数据");
    }

    @Override
    public void writeTFCard() {
        System.out.println("向TF卡中写入数据");
    }
}
