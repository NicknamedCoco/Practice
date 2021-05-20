package world.keyi.basic.templateMethod;

/**
 * @author 万一
 * @date 2021年05月20日12:06
 */
public class MyServlet extends FakeHttpServlet {
    protected void doPost() {
        System.out.println("doPost，子类具体实现");
    }

    protected void doGet() {
        System.out.println("doGet，子类具体实现");
    }
}
