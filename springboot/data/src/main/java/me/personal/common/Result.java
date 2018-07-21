package me.personal.common;

/**
 * Created by zhongyi on 2018/7/21.
 */
public class Result<T> {

    private boolean success;

    private T data;

    private String message;

    public Result(boolean success){
        this.success = success;
    }

    public Result(){
        this(true);
    }

    public Result(boolean success,String message){
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}