/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.openhome;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.*;

/**
 *
 * @author Justin
 */
public class Exercise {
    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(
            "INSERT INTO t_message(name, email, msg) VALUES (?,?,?)",
            "測試員", "tester@openhome.cc", "這是一個測試留言");
    }
}
