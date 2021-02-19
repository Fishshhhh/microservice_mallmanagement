package com.springcloud.dao;

import com.springcloud.po.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 宋雪
 * @Date: 2021/2/6 15:22
 * @Description:
 */
@Repository
@Mapper
public interface OrderMapper {
    @Insert("insert into tb_order(createtime,number,userid)values(#{createtime},#{number},#{userid}")
    public Integer addOrder(Order order);
    @Delete("delete from tb_order where id = #{id}")
    public Integer deleteOrder(Integer id);
    @Select("select * from tb_order")
    public List<Order> selectOrderAll();
    @Select("select * from tb_order where userid = #{id}")
    public List<Order> selectOrder(Integer id);
}
