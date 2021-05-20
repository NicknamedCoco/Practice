package world.keyi.basic.templateMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 万一
 * @date 2021年05月20日11:54
 */
public abstract class FakeHttpServlet {
    //模板方法
    protected void service(){
        doGet();
        doPost();
        doDelete();
        doPut();
    }

    private void doPut() {
        System.out.println("doPut方法，父类的具体方法");
    }

    private void doDelete() {
        System.out.println("doDelete方法，父类的具体方法");
    }

    protected abstract void doPost();

    protected abstract void doGet();

}
