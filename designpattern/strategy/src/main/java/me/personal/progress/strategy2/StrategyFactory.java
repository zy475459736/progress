package me.personal.progress.strategy2;

import me.personal.progress.strategy2.entities.BusiAcctStrategy;
import me.personal.progress.strategy2.entities.CardStrategy;
import me.personal.progress.strategy2.entities.EBankStrategy;
import me.personal.progress.strategy2.entities.MobileStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongyi on 2018/8/22.
 */
public class StrategyFactory {

    private static StrategyFactory factory = new StrategyFactory();
    private StrategyFactory(){
    }
    private static Map<Integer,IStrategy> strategyMap = new HashMap<>();
    static{
        strategyMap.put(RechargeTypeEnum.E_BANK.value(), new EBankStrategy());
        strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new BusiAcctStrategy());
        strategyMap.put(RechargeTypeEnum.MOBILE.value(), new MobileStrategy());
        strategyMap.put(RechargeTypeEnum.CARD_RECHARGE.value(), new CardStrategy());
    }
    public IStrategy creator(Integer type){
        return strategyMap.get(type);
    }
    public static StrategyFactory getInstance(){
        return factory;
    }
}
