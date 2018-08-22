package me.personal.progress.strategy;

/**
 * Created by zhongyi on 2018/8/22.
 */
public class Context{
    Strategy strategy;
    public Context(Strategy strategy){  //初始化时，传入具体的策略对象
        this.strategy = strategy;
    }
    //上下文接口
    public void AlgorithmInterface(){    //根据具体的策略对象调用其算法方法
        strategy.AlgorithmInterface();
    }
}