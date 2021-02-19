package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.dao.OrderMapper;
import com.springcloud.po.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 宋雪
 * @Date: 2021/2/5 16:12
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @GetMapping("/findOrders/{userid}")
    @HystrixCommand(fallbackMethod = "findOrderfallback")
    public List<Order> findOrder(@PathVariable Integer userid){
        List<Order> orders= this.orderMapper.selectOrder(userid);
        return orders;
    }
    public List<Order> findOrderfallback(@PathVariable Integer userid){
        List<Order> orders = new ArrayList<>();
        Order tip = new Order();
        tip.setId(0);
        orders.add(tip);
        return orders;
    }

}
