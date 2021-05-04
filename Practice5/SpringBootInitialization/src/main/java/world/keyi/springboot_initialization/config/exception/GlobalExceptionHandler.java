package world.keyi.springboot_initialization.config.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 万一
 * @date 2021年04月30日13:09
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandle(Exception e){
        ModelAndView modelAndView = new ModelAndView("error/404.html");
        modelAndView.addObject("exception",e);
        return modelAndView;
    }
}
