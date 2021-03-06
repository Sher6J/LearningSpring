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
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须再类路径下，不在的加载不了(更常用)
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的
     *
     * 核心容器的两个接口：
     *  ApplicationContext： 单例对象适用       实际开发多采用此接口
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，即，只要一读取完配置文件马上就创建配置文件中配置的对象
     *  BeanFactory：  多例对象适用
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式，即，什么时候根据id获取对象，什么时候才创建对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\IdeaProjects\\day01_spring\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象  ————  两种方式
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);

        System.out.println(as);
        System.out.println(accountDao);
    }
}
