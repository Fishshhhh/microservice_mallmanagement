package com.springcloud.dao;

import com.springcloud.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 宋雪
 * @Date: 2021/2/9 20:44
 * @Description:
 */
@Repository
@Mapper
public interface UserMapper {
    @Select("select * from tb_user where username = #{username}")
    public User selectUser(String username);
}
