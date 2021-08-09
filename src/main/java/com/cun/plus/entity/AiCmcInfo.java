package com.cun.plus.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
@TableName("aicmcinfo")
@Data
public class AiCmcInfo {
    @TableId(value = "accountId",type = IdType.UUID)
    private String accountId;
    private String name;
    private String companyName;
    private String email;
    private String gender;
    private String mobile;
    private String nickName;
    private int numberId;
    private String username;
    private String costCenterName;
}