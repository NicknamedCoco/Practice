package world.keyi.view.servlet;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonString;
import com.ramostear.captcha.HappyCaptcha;
import world.keyi.service.UserService;
import world.keyi.service.UserServiceImpl;
import world.keyi.view.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action.equals("queryAllUser")){
            doQueryAllUser(req,resp);
        }else if(action.equals("ajax")){
            doAjax(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action.equals("register")){
            doRegister(req,resp);
        }else if (action.equals("login")){
            doLogin(req,resp);
        }
    }

    private void doRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        UserService service = new UserServiceImpl();
        String result = service.register(user);
        req.setAttribute("registerResult",user.getUsername()+"用户"+result);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        String code = req.getParameter("code");

        UserService service = new UserServiceImpl();
        Boolean result = service.login(user);
        //验证码校验
        boolean flag = HappyCaptcha.verification(req, code, true);
        if (result&&flag){
            HttpSession session = req.getSession();
            session.setAttribute("loginSuccess",user.getUsername()+"用户登录成功");
            resp.sendRedirect("/OneForAll/home.jsp");
        }else {
            //删除session中的验证码
            HappyCaptcha.remove(req);
            req.setAttribute("loginError","登陆失败");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }

    private void doQueryAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        List<User> users = service.queryAllUser();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }
    private void doAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        username=new String(username.getBytes("iso-8859-1"),"utf-8");
        UserService service = new UserServiceImpl();
        Boolean flag = service.query(username);
        String result=null;
        if (flag){
            result="用户已存在，不可用";
        }else{
            result="用户名可用";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",username+result);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(jsonObject.toString());
    }

}
