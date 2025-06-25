package com.gaoyifeng.commom.infrastructure;

/**
 * @author gaoyifeng
 * @Classname ResultCode
 * @Description TODO 结果封装状态码枚举类
 * @Date 2025/6/25 17:05
 * @Created by gaoyifeng
 */
public enum ResultCode {

    _200("200","访问成功"),
    // （服务器内部错误） 服务器遇到错误，无法完成请求。
    _500("500","服务器遇到错误，无法完成请求");

    private String code;
    private String info;

    ResultCode(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

}
