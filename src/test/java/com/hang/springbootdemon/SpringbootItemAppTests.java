package com.hang.springbootdemon;

import com.hang.springbootdemon.entity.Person;
import com.hang.springbootdemon.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootItemAppTests {
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    DataSource dataSource;

    @Test
    public void testPersonDao() {
        Person person = personMapper.findPersonById(1L);
        System.out.println(person);
    }

    /**
     * 测试druid 连接池 配置参数是否起效
     */
    @Test
    public void testDruid(){
        String s = dataSource.toString();
        System.out.println(s);
    }

}
