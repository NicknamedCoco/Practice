package world.keyi.basic.dutyChain;

/**
 * @author 万一
 * @date 2021年05月20日13:51
 */
public class Father extends Family {
    @Override
    protected void handleRequest(int money) {
        if (money<=50){
            System.out.println("爸爸有，爸爸给你");
        }else {
            System.out.println("爸爸没有这么多钱");
            if (getNext()!=null){
                getNext().handleRequest(money);
            }
        }
    }
}
