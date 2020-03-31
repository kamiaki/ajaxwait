package com.aki.ajaxwait;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class AjaxController {
    public String Suo = "";
    private static Lock lock = new ReentrantLock();
    public static ConcurrentHashMap map = new ConcurrentHashMap();

    //http://192.168.2.15:8077/sso/testWait
    @RequestMapping(value = "testWait")
    public String testWait(String uuid, HttpServletRequest request){
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/qrcodelogin/notifyRequest/";
        System.out.println(basePath);

        Condition condition = lock.newCondition();
        map.put(uuid, condition);

        this.lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            this.lock.unlock();
        }

        return uuid + "被解锁";
    }

    @RequestMapping(value = "open")
    public String open(String uuid){
        Condition o = (Condition)map.get(uuid);
        this.lock.lock();
        try {
            o.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.lock.unlock();
        }

        return "解锁" + uuid;
    }
}
