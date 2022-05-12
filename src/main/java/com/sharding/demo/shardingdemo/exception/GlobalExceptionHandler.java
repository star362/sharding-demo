package com.sharding.demo.shardingdemo.exception;


import com.sharding.demo.shardingdemo.exception.response.Result;
import com.sharding.demo.shardingdemo.resps.ErrorsMessageEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/5/12 10:36
 * @describe: <br>
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常
     */
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result commonExceptionHandler(CommonException ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }


    /**
     * 空指针异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result nullPointerExceptionHandler(NullPointerException ex) {
        System.err.println("NullPointerException:");
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 类型转换异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * IO异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(IOException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result iOExceptionHandler(IOException ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 未知方法异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 数组越界异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({TypeMismatchException.class})
    public Result requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Result requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 405错误
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result request405(HttpRequestMethodNotSupportedException ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 406错误
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public Result request406(HttpMediaTypeNotAcceptableException ex) {
        System.out.println("406...");
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 500错误
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public Result server500(RuntimeException ex) {
        System.out.println("500...");
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 栈溢出
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({StackOverflowError.class})
    public Result requestStackOverflow(StackOverflowError ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    /**
     * 除数不能为0
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ArithmeticException.class})
    public Result arithmeticException(ArithmeticException ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }


    /**
     * 其他错误
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public Result exception(Exception ex) {
        return resultFormat(ErrorsMessageEnum.FAILURE.getCode(), ex);
    }

    private <T extends Throwable> Result resultFormat(String code, T ex) {
        ex.printStackTrace();
        log.error("Capture Exception By GlobalExceptionHandler: Code: {} Detail: {}", code, ex.getMessage());
        return Result.failure(code, ex.getMessage());
    }


}
