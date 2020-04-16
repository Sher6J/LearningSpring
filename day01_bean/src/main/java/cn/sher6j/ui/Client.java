package cn.sher6j.ui;


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
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\IdeaProjects\\day01_spring\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象  ————  两种方式
        AccountService as1 = (AccountService) ac.getBean("accountService");
        as1.saveAccount();

        //手动关闭容器
        ac.close();
    }
}
