package com.yzf.test;

import com.yzf.pojo.Cart;
import com.yzf.pojo.CartItem;
import com.yzf.service.OrderService;
import com.yzf.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Oracle",2,new BigDecimal(1000),new BigDecimal(2000)));
        OrderService orderService = new OrderServiceImpl();
        orderService.createOrder(cart,1);
    }
}