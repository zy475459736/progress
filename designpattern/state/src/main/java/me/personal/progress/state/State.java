package me.personal.progress.state;

/**
 * Created by zhongyi on 2018/8/23.
 */
public abstract class State {
    //声明抽象业务方法，不同的具体状态类可以不同的实现
    public abstract void handle();
}