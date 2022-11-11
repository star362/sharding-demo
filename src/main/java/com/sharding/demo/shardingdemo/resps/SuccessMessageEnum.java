package com.sharding.demo.shardingdemo.resps;

public enum SuccessMessageEnum {

    LOGIN_SUCCESS("1", "成功！"),

    ;


    private String code;

    private String desc;

    SuccessMessageEnum(String code, String desc) {
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
