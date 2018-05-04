package com.testcase.plaintest.security.domain;

import com.testcase.plaintest.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenu extends BaseModel {
    private String  name;
    private String  pId;
    private String  url;
    private Integer orderNum;
    private String  icon;
    private String  createBy;
    private Date    createDate;
    private String  updateBy;
    private Date    updateDate;
    private String  permission;
    private Byte    menuType;
}