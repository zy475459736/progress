package me.personal.progress.strategy2.entities;

import me.personal.progress.strategy2.IStrategy;
import me.personal.progress.strategy2.RechargeTypeEnum;

/**
 * Created by zhongyi on 2018/8/22.
 */
public class BusiAcctStrategy implements IStrategy {

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge*0.90;
    }
}
