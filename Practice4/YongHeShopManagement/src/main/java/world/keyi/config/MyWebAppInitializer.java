package world.keyi.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

/**
 * @author 万一
 * @date 2021年04月19日8:53
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
        获取根容器的配置类(Spring的配置类)，父容器
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /*
        获取Web容器的配置类(SpringMVC的配置类)，子容器
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /*
        获取DispatchServlet的映射信息
        /拦截所有请求，包括静态请求，但不包括*.jsp
        /*拦截所有请求，包括静态请求，包括*.jsp
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*
     *   配置请求转换器和字符过滤器
     * */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceRequestEncoding(true);
        encodingFilter.setForceResponseEncoding(true);
        encodingFilter.setForceEncoding(true);
        /*
        * 大坑，我吐了，找半天错误,字符编码过滤器要放在前面！！！
        * */
        return new Filter[]{encodingFilter,new HiddenHttpMethodFilter()};
    }
}
