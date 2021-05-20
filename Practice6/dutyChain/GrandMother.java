package world.keyi.basic.dutyChain;

/**
 * @author 万一
 * @date 2021年05月20日13:59
 */
public class GrandMother extends Family {
    @Override
    protected void handleRequest(int money) {
        if (money<=10000){
            System.out.println("奶奶有，奶奶给你");
        }else {
            System.out.println("奶奶没有这么多钱");
            if (getNext()!=null){
                getNext().handleRequest(money);
            }
        }
    }
}
