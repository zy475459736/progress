package me.personal.progress.strategy;

/**
 * Created by zhongyi on 2018/8/22.
 */
public class test {
    public static void main(String[] args) {
        Context context;
        //由于实例化不同的策略，在调用context.AlgorithmInterface();时，所获得的结果也不同。
        context = new Context(new ConcreteStrategyA());
        context.AlgorithmInterface();
        context = new Context(new ConcreteStrategyB());
        context.AlgorithmInterface();
        /**
         *
         //工厂模式用法
         Strategy s = StrategyFactory.createStrategy(type);
         ... = s.GetResult();
         //策略与工厂结合
         Context c = Context(type);
         ... = c.GetResult();
         * */



    }
}