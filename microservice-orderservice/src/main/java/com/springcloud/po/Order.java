package com.springcloud.po;

import lombok.Data;

/**
 * @author 宋雪
 * @Date: 2021/2/6 15:19
 * @Description:
 */
@Data
public class Order<DateTime> {
    private Integer id;
    private DateTime createtime;
    private String number;
    private Integer userid;
}
