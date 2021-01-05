package com.yzf.service;

import com.yzf.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
