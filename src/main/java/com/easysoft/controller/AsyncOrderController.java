package com.easysoft.controller;

import com.easysoft.service.DeferredQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

@Controller
public class AsyncOrderController {

    @Autowired
    private DeferredQueueService queueService;

    @ResponseBody
    @RequestMapping("/add")
    public DeferredResult<Object> add() {
        DeferredResult<Object> deferredResult = new DeferredResult<Object>((long) 5000, "add fail.");
        deferredResult.setResult(UUID.randomUUID().toString());
        queueService.add(deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @RequestMapping("/poll")
    public String poll() {
        DeferredResult<Object> deferredResult = queueService.poll();
        return (String) deferredResult.getResult();
    }

    @ResponseBody
    @RequestMapping("/order01")
    public Callable<String> order01() {
        System.out.println("主线程开始==>" + Thread.currentThread() + "----->" + System.currentTimeMillis());

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("副线程开始==>" + Thread.currentThread() + "----->" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("副线程结束==>" + Thread.currentThread() + "----->" + System.currentTimeMillis());
                return "order buy successfully.";
            }
        };

        System.out.println("主线程结束==>" + Thread.currentThread() + "----->" + System.currentTimeMillis());
        return callable;
    }
}
