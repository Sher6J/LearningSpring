package cn.sher6j.ui;

import cn.sher6j.dao.AccountDao;
import cn.sher6j.dao.impl.AccountDaoImpl;
import cn.sher6j.service.AccountService;
import cn.sher6j.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\IdeaProjects\\day01_spring\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountService as2 = (AccountService) ac.getBean("accountService");

//        System.out.println(as == as2);
        as.saveAccount();
        ac.close();
    }
}
