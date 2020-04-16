package cn.sher6j.factory;

import cn.sher6j.service.AccountService;
import cn.sher6j.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能是存在于jar包中，我们无法通过修改源码的方式提供默认构造函数）
 * @author sher6j
 * @create 2020-04-13-16:50
 */
public class InstanceFactory {

    public AccountService getAccoutService(){
        return new AccountServiceImpl();
    }
}
