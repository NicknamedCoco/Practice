package world.keyi.basic.dutyChain;

/**
 * @author 万一
 * @date 2021年05月20日14:00
 */
public class DutyChainTest {
    public static void main(String[] args) {
        Family father = new Father();
        Family mother = new Mother();
        Family grandMother = new GrandMother();
        father.setNext(mother);
        mother.setNext(grandMother);
        father.handleRequest(3000);
    }
}
