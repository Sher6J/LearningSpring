package cn.sher6j.service.impl;

import cn.sher6j.dao.AccountDao;
import cn.sher6j.domain.Account;
import cn.sher6j.service.AccountService;
import cn.sher6j.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务控制应该都在业务层
 * @author sher6j
 * @create 2020-04-13-22:09
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {

        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {

        //2.1.根据名称查询转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //2.2.根据名称查询转入账户
        Account targetAccount = accountDao.findAccountByName(targetName);
        //2.3.转出账户减钱
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        //2.4.转入账户加钱
        targetAccount.setMoney(targetAccount.getMoney() + money);
        //2.5.更新转出账户
        accountDao.updateAccount(sourceAccount);
//        int i = 1 / 0;
        //2.6.更新转入账户
        accountDao.updateAccount(targetAccount);


    }
}
