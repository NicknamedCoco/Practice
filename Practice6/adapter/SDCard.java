package world.keyi.basic.adapter;

/**
 * @author 万一
 * @date 2021年05月18日18:06
 */
public class SDCard implements Card {
    @Override
    public void read() {
        System.out.println("正在从sd卡中读取数据");
    }

    @Override
    public void write() {
        System.out.println("正在向sd卡中写入数据");
    }
}
