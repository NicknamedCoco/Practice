package world.keyi.arsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import world.keyi.arsystem.intercepter.LoginTokenInterception;

/**
 * @author 万一
 * @date 2021年06月23日8:00
 */
@Configuration
public class ARSystemWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private FileProperties fileProperties;

    /*
        配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        registry.addInterceptor(loginTokenInterception()).addPathPatterns("/**");
    }

    /*
        配置资源处理映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String imagePath = fileProperties.getImagePath();
        registry.addResourceHandler("/adminApi/image/avatar/**").addResourceLocations(imagePath);
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /*
        设置跨域
        addMapping，设置可以被跨域的路径
        allowedOrigins，域名的白名单
        allowedMethods，请求的方式，GET,POST,DELETE,PUT
        allowedHeaders，允许所有请求header访问，可以自定义设置任意请求头信息
        maxAge，这个是给复杂请求预检用的，设置预检多久失效
    */
    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("*").allowedHeaders("*").maxAge(3600);
    }*/

    /*
        登录验证拦截器
     */
    @Bean
    public LoginTokenInterception loginTokenInterception(){
        return new LoginTokenInterception();
    }
}
