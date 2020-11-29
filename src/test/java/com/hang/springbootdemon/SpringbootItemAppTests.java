package com.hang.springbootdemon;

import com.hang.springbootdemon.entity.Person;
import com.hang.springbootdemon.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootItemAppTests {
    @Autowired
    private PersonMapper personMapper;
    @Test
    public void testPersonDao() {
        Person person = personMapper.findPersonById(1L);
        System.out.println(person);
    }

}
