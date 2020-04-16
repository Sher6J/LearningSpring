package cn.sher6j.service.impl;

import cn.sher6j.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {


    /**
     * 这样的话就没了默认构造函数
     * @param
     */
    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了。。。");
    }

    public void init() {
        System.out.println("对象初始化了");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }
}
