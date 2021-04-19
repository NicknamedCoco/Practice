package world.keyi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 万一
 * @date 2021年04月19日8:54
 */
@EnableWebMvc   /*相当于 <mvc:annotation-driven/>,自定义配置时可以加上*/
@ComponentScan(value = "world.keyi",useDefaultFilters = false,includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = ControllerAdvice.class)
})
public class WebConfig implements WebMvcConfigurer {
    /*
        视图解析器
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/pages/",".jsp");
    }

    /*
        静态资源映射
        相当于：<mvc:resources mapping="/resources/**" location="/statics/" />
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
    }
}
