package cn.sher6j.factory;

import cn.sher6j.service.AccountService;
import cn.sher6j.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类
 * @author sher6j
 * @create 2020-04-13-16:57
 */
public class StaticFactory {
    public static AccountService getAccoutService(){
        return new AccountServiceImpl();
    }
}
