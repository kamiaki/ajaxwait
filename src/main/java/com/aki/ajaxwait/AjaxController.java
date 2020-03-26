package com.aki.ajaxwait;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class AjaxController {
    public String Suo = "";
    public ConcurrentHashMap map = new ConcurrentHashMap();


    @RequestMapping(value = "testWait")
    public String testWait(String uuid){
        map.put(uuid, false);
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if((boolean)map.get(uuid) == true){
                break;
            }
        }
        return uuid + "被解锁";
    }

    @RequestMapping(value = "open")
    public String open(String uuid){
        map.put(uuid, true);
        return "解锁" + uuid;
    }
}
