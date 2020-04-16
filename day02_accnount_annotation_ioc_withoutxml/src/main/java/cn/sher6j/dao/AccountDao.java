package cn.sher6j.dao;

import cn.sher6j.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 * @author sher6j
 * @create 2020-04-13-22:11
 */
public interface AccountDao {
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
}
