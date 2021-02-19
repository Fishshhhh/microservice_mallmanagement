package com.springcloud.po;

import lombok.Data;

/**
 * @author 宋雪
 * @Date: 2021/2/10 1:36
 * @Description:
 */

@Data
public class Order<DateTime> {
    private Integer id;
    private DateTime createtime;
    private String number;
    private Integer userid;
}
