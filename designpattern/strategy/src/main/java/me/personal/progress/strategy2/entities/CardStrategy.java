package me.personal.progress.strategy2.entities;

import me.personal.progress.strategy2.IStrategy;
import me.personal.progress.strategy2.RechargeTypeEnum;

/**
 * Created by zhongyi on 2018/8/22.
 */
public class CardStrategy implements IStrategy {

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge + charge * 0.01;
    }
}