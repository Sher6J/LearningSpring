package jdbctemplate;

import cn.sher6j.dao.IAccountDao;
import cn.sher6j.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sher6j
 * @create 2020-04-15-10:06
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }
}
