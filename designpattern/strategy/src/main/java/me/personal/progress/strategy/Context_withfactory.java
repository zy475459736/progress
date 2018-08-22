package me.personal.progress.strategy;

/**
 * Created by zhongyi on 2018/8/22.
 */

public class Context_withfactory{
    Strategy strategy = null;  //声明一个接口对象
    public Context_withfactory(String type){  //初始化时，在Context类中实现简单工厂的应用。
        switch(type){
            case "需求一":
                Strategy s1 = new ConcreteStrategyA();
                strategy = s1;
                break;
            case "需求二":
                Strategy s2 = new ConcreteStrategyB();
                strategy = s2;
                break;
        }
    }
    public void GetResult(){
        strategy.AlgorithmInterface();
    }
}
