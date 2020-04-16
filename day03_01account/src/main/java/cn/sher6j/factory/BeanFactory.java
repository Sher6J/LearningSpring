package cn.sher6j.factory;

import cn.sher6j.domain.Account;
import cn.sher6j.service.AccountService;
import cn.sher6j.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工程
 * @author sher6j
 * @create 2020-04-14-16:42
 */
public class BeanFactory {
    private AccountService accountService;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        try {
                            System.out.println("转钱开始");
                            //1. 开启事务
                            txManager.beginTransaction();
                            //2. 执行操作
                            returnValue = method.invoke(accountService, args);
                            //3. 提交事务
                            txManager.commit();
                            //4. 返回结果
                            return returnValue;
                        } catch (Exception e) {
                            //5. 回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6. 释放资源
                            txManager.release();
                        }
                    }
                });
    }
}
