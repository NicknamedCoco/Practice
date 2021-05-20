package world.keyi.basic.dutyChain;

/**
 * @author 万一
 * @date 2021年05月20日13:57
 */
public class Mother extends Family {
    @Override
    protected void handleRequest(int money) {
        if (money<=1000){
            System.out.println("妈妈有，妈妈给你");
        }else {
            System.out.println("妈妈没有这么多钱");
            if (getNext()!=null){
                getNext().handleRequest(money);
            }
        }
    }
}
