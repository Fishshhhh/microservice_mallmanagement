package com.springcloud.controller;

import com.springcloud.dao.UserMapper;
import com.springcloud.po.Order;
import com.springcloud.po.User;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 宋雪
 * @Date: 2021/2/9 20:37
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserMapper userMapper;
    @Value("${ORDERSERVICEURL}")
    private String ORDERSERVICEURL;
    @GetMapping(path="/findOrders/{username}")
    public List<Order> getOrderByUsername(@PathVariable("username") String username){
        //System.out.println(username);
        User user = userMapper.selectUser("sx");
        //System.out.println("*************"+restTemplate);
        //System.out.println("*************"+ORDERSERVICEURL);
        //System.out.println("*************"+user);
        //System.out.println("*************"+user.getId());
        ResponseEntity<List<Order>> rateResponse=
                restTemplate.exchange(ORDERSERVICEURL + "order/findOrders/" + user.getId(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Order>>() {});
        List<Order> orders =rateResponse.getBody();
        return orders;
    }
}
