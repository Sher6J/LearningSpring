package cn.sher6j.service.impl;

import cn.sher6j.dao.AccountDao;
import cn.sher6j.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 * 曾经xml配置文件中的配置：
 * <bean id="accountService" class="cn.sher6j.service.impl.AccountServiceImpl"
 *      scope=""  init-method="" destroy-method="">
 *     <property name="" value="" / ref = ""></property>
 * </bean>
 *
 * 用于创建对象的
 *      他们的作用和xml配置文件中编写一个<bean></bean>标签实现的功能是一样的
 *      Component：
 *          作用：用于把当前类对象存入spring容器中
 *          属性：
 *              value：用于指定bean的id。当不写时，其默认值是当前类名且首字母改小写
 *      Controller：一般用在表现层
 *      Service：一般用在业务层
 *      Repository：一般用在持久层
 *      以上三个注解，他们的作用和属性与Component一模一样，
 *      他们三个是spring框架为我们提供明确的三层使用的注解，使我们三层对象更加清晰
 * 用于注入数据的
 *      他们的作用和xml配置文件中的bean标签中的<property></property>标签的作用是一样的
 *      Autowired：
 *          作用：自动按照类型注入，只要Ioc容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功，
 *                如果Ioc容器中没有任何bean的类型和要注入的变量类型匹配，就会报错。
 *                如果Ioc容器中有多个类型匹配时
 *                    有相同名称的就可以注入成功，
 *                    没有相同名称的就会发生如下错误：
 *                      NoUniqueBeanDefinitionException:
 *                      No qualifying bean of type 'cn.sher6j.dao.AccountDao' available:
 *                      expected single matching bean but found 2: accountDao1,accountDao2
 *          出现位置：
 *              可以是成员变量上，也可以是方法上
 *          细节：
 *              在使用注解注入时，set方法就不是必须的了
 *      Qualifier：
 *          作用：在按照类中注入的基础之上再按照名称注入。
 *                它在给类成员注入时不能单独使用，依托于Autowired，但是在给方法参数注入时可以
 *          属性：
 *              value：用于指定注入bean的id
 *      Resource：
 *          作用：直接按照bean的id注入，它可以独立使用，不用依托于Autowired
 *          属性：
 *              name：用于指定bean的id
 *      以上三个注解都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 *      另外！！集合类型的注入只能通过xml来实现
 *      Value：
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值，它可以使用spring中的SpEl（也就是spring中的EL表达式）
 *                     SpEL的写法：${表达式}
 *
 * 用于改变作用范围的
 *      他们的作用和bean标签中的scope属性是一样的
 *      Scope：
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。常用取值：singleton prototype，默认singleton
 * 和生命周期相关的（了解即可）
 *      他们的作用和bean标签中的init-method和destroy-method是一样的
 *      PreDestroy：
 *          作用：用于指定销毁方法
 *      PostConstruct
 *          作用：用于指定初始化方法
 */
@Component("accountService")
@Scope("singleton")
public class AccountServiceImpl implements AccountService {

//    @Autowired
//    @Qualifier("accountDao2")//在给类成员注入时，不能独立使用，没有@Autowired会产生空指针异常

    @Resource(name = "accountDao2")
    private AccountDao accountDao ;

    @PostConstruct
    public void init() {
        System.out.println("初始化了");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
