package world.keyi.basic.dutyChain;

/**
 * @author 万一
 * @date 2021年05月20日13:47
 */
//父类
public abstract class Family {
    private Family next;
    public Family getNext() {
        return next;
    }
    public void setNext(Family next) {
        this.next = next;
    }

    protected abstract void handleRequest(int money);
}
