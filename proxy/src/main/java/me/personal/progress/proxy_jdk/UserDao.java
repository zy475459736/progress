package me.personal.progress.proxy_jdk;

import me.personal.progress.IUserDao;

/**
 * Created by zhongyi on 2018/8/19.
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("---------已经保存数据----------");
    }

    @Override
    public void save_() {
        System.out.println("---------another method save.---------");
    }

}