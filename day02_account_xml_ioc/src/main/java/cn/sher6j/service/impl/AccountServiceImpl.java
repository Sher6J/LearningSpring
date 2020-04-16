package cn.sher6j.service.impl;

import cn.sher6j.dao.AccountDao;
import cn.sher6j.domain.Account;
import cn.sher6j.service.AccountService;

import java.util.List;

/**
 * 账户的业务层实现类
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
}
