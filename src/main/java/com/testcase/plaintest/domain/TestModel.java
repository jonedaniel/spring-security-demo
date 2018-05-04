package com.testcase.plaintest.domain;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Map;

@Data
public class TestModel {
    public static final Map GUARANTED_WAY =(Map) JSON.parse("{\"1\":\"信用\",\"2\":\"抵质押\",\"3\":\"擔保\",\"4\":\"保險\"}");
}
