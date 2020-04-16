package cn.sher6j.service.impl;

import cn.sher6j.service.IAccountService;

/**
 * 账户的业务层实现类
 * @author sher6j
 * @create 2020-04-14-17:29
 */
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
