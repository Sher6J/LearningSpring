package cn.sher6j.service;

import cn.sher6j.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 * @author sher6j
 * @create 2020-04-13-22:04
 */
public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存操作
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新操作
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除用户
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, float money);
}
