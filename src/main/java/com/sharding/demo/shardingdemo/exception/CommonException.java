package com.sharding.demo.shardingdemo.exception;


import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/5/12 9:59
 * @describe: 自定义全局异常<br>
 */
@RestControllerAdvice
public class CommonException extends Exception {

    /**
     * 错误码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CommonException() {
        super();
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }
}
