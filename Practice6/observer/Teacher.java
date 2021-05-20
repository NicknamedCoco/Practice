package world.keyi.basic.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 万一
 * @date 2021年05月20日10:36
 */
public abstract class Teacher {
    List<Student> students = new ArrayList<>();

    private String msg;

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
        notifyStudent(msg);
    }

    //新增观察者，新增订阅
    public void add(Student student){
        students.add(student);
    }
    //取消订阅
    public void remove(Student student){
        students.remove(student);
    }

    //通知所有观察者
    public abstract void notifyStudent(String msg);

}
