package world.keyi.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class UserException {

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView ArithmeticError(Exception exception){
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("error",exception);
        return mav;
    }
}
