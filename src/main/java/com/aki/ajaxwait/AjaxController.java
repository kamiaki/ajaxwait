package com.aki.ajaxwait;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    @RequestMapping(value = "testWait")
    public String testWait(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "返回内容";
    }

    @RequestMapping(value = "open")
    public String open(){
        return "开锁";
    }
}
