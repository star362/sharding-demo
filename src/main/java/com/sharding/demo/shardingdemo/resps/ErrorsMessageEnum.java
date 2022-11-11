package com.sharding.demo.shardingdemo.resps;

public enum ErrorsMessageEnum {

    FAILURE("-1", "错误"),

    ;


    private String code;

    private String desc;

    ErrorsMessageEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
