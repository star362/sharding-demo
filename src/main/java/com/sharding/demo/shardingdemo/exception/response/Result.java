package com.sharding.demo.shardingdemo.exception.response;


import com.sharding.demo.shardingdemo.resps.ErrorsMessageEnum;
import com.sharding.demo.shardingdemo.resps.SuccessMessageEnum;

/**
 * 返回对象实体
 *
 * @author star247@sunia.com
 */
//@ApiModel(value = "Result", description = "通用返回结果")
public class Result<T> implements java.io.Serializable {

    private static final long serialVersionUID = 1332083554709890293L;

//    @ApiModelProperty(value = "返回对象")
    private T data;

//    @ApiModelProperty(value = "内部状态编码")
    private String respCode;

//    @ApiModelProperty(value = "提示消息")
    private String respMessage;

//    @ApiModelProperty(value = "oken信息")
    private String token;

    public Result() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    /**
     * Description: 操作成功结果<br>
     *
     * @return
     */
    public static Result success() {
        return success(SuccessMessageEnum.LOGIN_SUCCESS.getDesc());
    }

    /**
     * Description: 操作成功结果，自定义信息<br>
     *
     * @param msg 自定义信息
     * @return
     */
    public static Result success(String msg) {
        return success(SuccessMessageEnum.LOGIN_SUCCESS.getCode(), msg);
    }

    /**
     * Description: 操作成功结果，自定义信息和返回数据对象<br>
     *
     * @param msg 自定义信息
     * @param <T> 返回数据对象
     * @return
     */
    public static <T> Result<T> success(String msg, T object) {
        Result result = new Result();
        result.setRespCode(SuccessMessageEnum.LOGIN_SUCCESS.getCode());
        result.setRespMessage(msg);
        result.setData(object);
        return result;
    }

    /**
     * Description:  操作成功结果，自定义编码和信息<br>
     *
     * @param code
     * @param message
     * @return
     */
    public static Result success(String code, String message) {
        Result result = new Result();
        result.setRespCode(code);
        result.setRespMessage(message);
        return result;
    }

    /**
     * Description: 操作失败结果<br>
     *
     * @return
     */
    public static Result failure() {
        return failure(ErrorsMessageEnum.FAILURE.getCode(), null);
    }

    /**
     * Description: 操作失败结果，自定义信息<br>
     *
     * @param msg 自定义信息
     * @return
     * @author L
     */
    public static Result failure(String msg) {
        return failure(ErrorsMessageEnum.FAILURE.getCode(), msg);
    }

    /**
     * Description:  操作失败结果，自定义信息和返回数据对象<br>
     *
     * @param msg    自定义信息
     * @param object 返回数据对象
     * @return
     */
    public static <T> Result<T> failure(String msg, T object) {
        Result result = new Result();
        result.setRespCode(ErrorsMessageEnum.FAILURE.getCode());
        result.setRespMessage(msg);
        result.setData(object);
        return result;
    }

    /**
     * Description:  操作失败结果，自定义编码和信息<br>
     * Created date: 2020年6月5日
     *
     * @param code
     * @param message
     * @return
     * @author L
     */
    public static Result failure(String code, String message) {
        Result result = new Result();
        result.setRespCode(code);
        result.setRespMessage(message);
        return result;
    }

    /**
     * 创建一个带有<b>状态</b>、<b>消息</b>和<b>数据</b>的结果对象.
     *
     * @param code
     *            状态
     * @param message
     *            消息内容
     * @param data
     *            数据
     * @return 结构数据
     */
    public static <T> Result<T> buildResult(String code, String message, T data) {
        Result result = new Result();
        result.setRespCode(code);
        result.setRespMessage(message);
        result.setData(data);
        return result;
    }

}
