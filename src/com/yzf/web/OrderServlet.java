package com.yzf.web;

import com.yzf.pojo.Cart;
import com.yzf.pojo.User;
import com.yzf.service.impl.OrderServiceImpl;
import com.yzf.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{
    private OrderServiceImpl orderService = new OrderServiceImpl();
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取cart对象和userId
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer userid = loginUser.getId();
        //生成订单
        String orderId = null;

        orderId = orderService.createOrder(cart, userid);

        req.getSession().setAttribute("orderId",orderId);
        //请求重定向


        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
