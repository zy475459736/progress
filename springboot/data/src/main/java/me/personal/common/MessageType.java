package me.personal.common;

/**
 * Created by zhongyi on 2018/7/23.
 */
public enum MessageType {

    SUCCESS(0, "请求成功完成。"),
    ERROR(-1, "发现错误。"),
    UNKNOWN(-4, "未知错误。");

    private int code;
    private String text;

    MessageType(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.text;
    }

}
