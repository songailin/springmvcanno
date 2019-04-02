package com.easysoft.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public String goBuy(String orderId) {
        return "buy orderId:" + orderId + " successfully...";
    }
}
