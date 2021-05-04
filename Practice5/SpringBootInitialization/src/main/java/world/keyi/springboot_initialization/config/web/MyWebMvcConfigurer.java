package world.keyi.springboot_initialization.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author 万一
 * @date 2021年04月30日9:06
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /*注册自定义拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    /*配置自定义视图解析器*/
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    /*配置参数解析器*/
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    /*配置内容协商*/
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    /*配置自定义WebConversionService，自定义类型转换器*/
    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    /*配置返回值处理器*/
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }

    /*配置自定义消息转换器*/
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    /*配置异常解析器*/
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }
}
