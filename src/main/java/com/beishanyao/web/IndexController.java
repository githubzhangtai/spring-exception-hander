package com.beishanyao.web;

import com.beishanyao.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@Slf4j
public class IndexController {

    @GetMapping("/")
    public String index(){
//        int i = 9/0;
        String test = null;
        if(test == null){
            log.error("test不存在");
            throw new NotFoundException("test不存在");
        }
        return "index";
    }
}
