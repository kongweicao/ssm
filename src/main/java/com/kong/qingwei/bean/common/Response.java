package com.kong.qingwei.bean.common;

/**
 * Created by kongwc on 2017/7/23.
 */

/**
 * Restful接口返回
 * @param <T>
 */
public class Response<T> {
    private String returnCode;
    private String returnMessage;
    private T data;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
