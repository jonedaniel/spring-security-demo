package com.testcase.plaintest;


public enum  TestEnum {
    //补偿金状态
    SHEET_DOWNLOADED(1),//已下载电子表格
    SHEET_UPLOADED(2),//已上传电子表格
    SHEET_REJECTED(-1),//电子表格未通过审核
    MATERIAL_NOT_UPLOAD(3),//（电子表格已上传）材料未上传
    MATERIAL_UPLOADED(4),//材料已上传
    MATERIAL_ADMIN_REJECTED(-2),//材料未通过管理员审核
    MATERIAL_ADMIN_PASSED(5),//材料通过管理员审核
    MATERIAL_GOV_REJECTED(-3),//材料未通过政府审核
    MATERIAL_GOV_PASSED(6),//材料已通过政府审核

    //政策名
    POLICY_1(1),//深圳市中小微企业贷款动产融资补偿金申请
    POLICY_2(2);//深圳市中小微企业贷款风险补偿金申请


    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    private TestEnum(int i) {
        this.val = i;
    }
}
