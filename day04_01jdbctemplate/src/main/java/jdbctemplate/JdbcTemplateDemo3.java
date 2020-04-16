package jdbctemplate;

import cn.sher6j.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD操作
 * @author sher6j
 * @create 2020-04-15-9:24
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作
        //保存
//        jt.update("insert into account(name, money)values (?, ?)","fff",1000f);
        //更新
//        jt.update("update account set name=?, money=? where id=?","abc",2000f, 7);
        //删除
//        jt.update("delete from account where id=?", 7);
        //查询所有
//        List<Account> accounts = jt.query("select * from account where money > ?", new AccontRowMapper(), 1000f);//得自己写封装
        List<Account> accounts = jt.query("select * from account where money > ?",
                new BeanPropertyRowMapper<>(Account.class), 900);//不用自己写包装了
        accounts.forEach(System.out::println);
        System.out.println("--------------");
        //查询一个
        List<Account> account = jt.query("select * from account where id = ?",
                new BeanPropertyRowMapper<>(Account.class), 1);
        System.out.println(account.isEmpty()?"没有内容":account.get(0));
        System.out.println("----------------");
        //查询返回一行一列（使用聚合函数，但不加group by字句）
        Integer count = jt.queryForObject("select count(*) from account where money > ?",
                Integer.class, 900f);
        System.out.println(count);
    }
}

/**
 * 定义Account的封装策略
 */
class AccontRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}