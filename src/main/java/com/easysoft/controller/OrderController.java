package com.easysoft.controller;

import com.easysoft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/buy")
    public String buy() {
        return orderService.goBuy("12345678");
    }

    @RequestMapping("/ok")
    public String ok() {
        return "ok";
    }
}
