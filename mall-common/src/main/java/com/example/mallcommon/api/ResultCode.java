package com.example.mallcommon.api;

public enum ResultCode implements IResultCode {
    SUCCESS(200, "操作成功"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    FAILED(500, "操作失败"),

    DATA_NOT_FOUND(5001, "数据未找到")

    ;


    private final long code;
    private final String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}