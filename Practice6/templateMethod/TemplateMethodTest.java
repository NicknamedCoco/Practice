package world.keyi.basic.templateMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 万一
 * @date 2021年05月20日12:08
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        FakeHttpServlet myServlet = new MyServlet();
        myServlet.service();
    }
}
