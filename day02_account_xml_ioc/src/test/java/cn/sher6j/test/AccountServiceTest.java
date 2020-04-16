package cn.sher6j.test;

import cn.sher6j.domain.Account;
import cn.sher6j.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试，测试配置
 * @author sher6j
 * @create 2020-04-13-22:29
 */
public class AccountServiceTest {

    @Test
    public void findAllAccount() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        accounts.forEach(System.out::println);

    }

    @Test
    public void findAccountById() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);

    }

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(100000f);
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void updateAccount() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(20000f);
        as.updateAccount(account);
    }

    @Test
    public void deleteAccount() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        as.deleteAccount(4);
    }
}
