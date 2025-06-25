package com.gaoyifeng.commom.infrastructure;

/**
 * @author gaoyifeng
 * @Classname Result
 * @Description TODO 结果封装类
 * @Date 2025/6/25 17:05
 * @Created by gaoyifeng
 */
public class Result<T> {

    private String code;
    private String info;
    private T data;

    protected Result(String code,String info,T data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }
    public static <T> Result success(T data){
        return new Result(ResultCode._200.getCode(), ResultCode._200.getInfo(), data);
    }
    public static Result buildError(String code, String info) {
        return new Result(code, info, null);
    }
    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public T getData() {
        return data;
    }

}
