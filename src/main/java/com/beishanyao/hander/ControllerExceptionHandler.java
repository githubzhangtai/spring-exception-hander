package com.beishanyao.hander;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * ControllerAdvice： 会拦截有【@Controller】标注的类
 * @author beishanyao
 * @date 2020/1/10
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        log.error("Request URL : {}, Exception : {}",request.getRequestURL(),e);

        /**
         * if模块
         * 标注了 ResponseStatus 状态的异常，不在此处统一处理，直接抛出异常，让 springboot 本身处理
         */
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        //返回到 templates 下的 error/error 页面
        mv.setViewName("error/error");
        return mv;
    }
}
