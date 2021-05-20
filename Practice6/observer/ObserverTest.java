package world.keyi.basic.observer;

/**
 * @author 万一
 * @date 2021年05月20日10:52
 */
public class ObserverTest {

    public static void main(String[] args) {
        Teacher englishT = new EnglishTeacher();
        Student wanyi = new WanyiStudent();
        Student xiaoPangStudent = new XiaoPangStudent();
        Student xiaoShouStudent = new XiaoShouStudent();
        englishT.add(wanyi);
        englishT.add(xiaoPangStudent);
        englishT.add(xiaoShouStudent);
        englishT.remove(wanyi);
        englishT.setMsg("上课！！！");
    }
}

