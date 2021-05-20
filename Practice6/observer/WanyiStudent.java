package world.keyi.basic.observer;

/**
 * @author 万一
 * @date 2021年05月20日10:48
 */
public class WanyiStudent implements Student {
    @Override
    public void action(String msg) {
        System.out.println(getClass().getName()+":老师说"+msg);
    }
}
