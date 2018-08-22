package me.personal.progress.strategy2;

/**
 * Created by zhongyi on 2018/8/22.
 */
public class Context {

    private IStrategy Istrategy;

    public Double calRecharge(Double charge, Integer type) {
        Istrategy = StrategyFactory.getInstance().creator(type);
        return Istrategy.calRecharge(charge, RechargeTypeEnum.valueOf(type));
    }

    public IStrategy getStrategy() {
        return Istrategy;
    }

    public void setStrategy(IStrategy Istrategy) {
        this.Istrategy = Istrategy;
    }

}
