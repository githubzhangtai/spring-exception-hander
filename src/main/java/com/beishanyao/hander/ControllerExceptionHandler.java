package com.beishanyao.hander;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * ControllerAdvice： 会拦截有【@Controller】标注的类
 * @author Kimi
 * @date 2020/1/10
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e){
        log.error("Request URL : {}, Exception : {}",request.getRequestURL(),e);

        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        //返回到 templates 下的 error/error 页面
        mv.setViewName("error/error");
        return mv;
    }
}
