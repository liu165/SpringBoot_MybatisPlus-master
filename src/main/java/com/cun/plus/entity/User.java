package com.cun.plus.entity;

import com.baomidou.mybatisplus.annotations.DataSource;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@TableName("user") // 默认类名
@Data
public class User {

    @TableId(value = "id", type = IdType.AUTO) // 必注解
    private Integer id;
    private String username;
    private String password;


}
