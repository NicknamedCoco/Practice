package world.keyi.basic.observer;

/**
 * @author 万一
 * @date 2021年05月20日10:44
 */
public class EnglishTeacher extends Teacher {
    @Override
    public void notifyStudent(String msg) {
        for (Student student : super.students) {
            student.action(msg);
        }
    }
}
