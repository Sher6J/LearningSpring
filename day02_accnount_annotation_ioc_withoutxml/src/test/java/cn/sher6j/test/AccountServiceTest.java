package cn.sher6j.test;

import cn.sher6j.domain.Account;
import cn.sher6j.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试配置
 * Spring整合Junit的配置
 *     1. 导入spring整合Junit的jar包（坐标）
 *     2. 使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *         @Runwith
 *     3. 告知spring的运行器，spring的ioc创建时基于xml还是注解，并且说明位置
 *         @ContextConfiguration
 *              locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在的位置
 *  当我们使用spring5.x版本的时候，要求Junit的jar必须是4.12及以上
 * @author sher6j
 * @create 2020-04-13-22:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService as;

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
