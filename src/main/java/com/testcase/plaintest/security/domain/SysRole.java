package com.testcase.plaintest.security.domain;

import com.testcase.plaintest.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole extends BaseModel {
    private String roleName;
    private String remark;
    private String createBy;
    private Date   createDate;
    private String updateBy;
    private Date   updateDate;
}