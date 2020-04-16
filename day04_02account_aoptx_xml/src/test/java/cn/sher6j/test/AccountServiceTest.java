package cn.sher6j.test;

import cn.sher6j.domain.Account;
import cn.sher6j.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试配置
 * @author sher6j
 * @create 2020-04-13-22:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService as;

    @Test
    public void transfer() {
        as.transfer("aaa","bbb",100f);
    }

    @Test
    public void findAllAccount() {
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        accounts.forEach(System.out::println);

    }

    @Test
    public void findAccountById() {
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);

    }

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(100000f);
        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void updateAccount() {
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(20000f);
        as.updateAccount(account);
    }

    @Test
    public void deleteAccount() {
        //3.执行方法
        as.deleteAccount(4);
    }
}
