package world.keyi.view.filter;

import javax.servlet.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/home.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        if (session.getAttribute("loginSuccess")==null){
            req.setAttribute("unLogin","您尚未登录，请先登录");
            req.getRequestDispatcher("/index.jsp").forward(req,res);
        }else{
            filterChain.doFilter(req,res);
        }
    }

    @Override
    public void destroy() {

    }
}
