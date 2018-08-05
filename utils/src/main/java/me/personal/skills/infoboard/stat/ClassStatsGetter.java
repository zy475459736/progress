package me.personal.skills.infoboard.stat;

import me.personal.skills.infoboard.common.ClassStats;
import me.personal.skills.infoboard.common.Stats;
import me.personal.skills.infoboard.common.StatsGetter;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;


public class ClassStatsGetter implements StatsGetter {
    ClassLoadingMXBean bean = ManagementFactory.getClassLoadingMXBean();
    @Override
    public Stats get() {
        ClassStats s = new ClassStats();
        s.setCurrentClassCount(bean.getLoadedClassCount());
        s.setBeenLoadedClassCount(bean.getTotalLoadedClassCount());
        s.setBeenUnloadedClassCount(bean.getUnloadedClassCount());
        return s;
    }
}
