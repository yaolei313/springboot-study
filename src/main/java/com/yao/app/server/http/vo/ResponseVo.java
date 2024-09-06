package com.yao.app.server.http.vo;

/**
 *
 */
public class ResponseVo<T> {

    private int code;

    private T data;

    public ResponseVo(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    // ----

    public static final <T> ResponseVo create(int code, T data) {
        return new ResponseVo(code, data);
    }
}
