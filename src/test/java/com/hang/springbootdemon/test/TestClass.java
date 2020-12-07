package com.hang.springbootdemon.test;

import com.hang.springbootdemon.entity.Person;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import java.util.Set;

/**
 * 测试类
 *
 * @author huangjh
 * @date 2020/8/24
 */
public class TestClass {
    @Test
    public void fun01() {
       /* Person person = new Person();
        person.setName("小明");
        person.setAge(18);
        testParam(person);
        System.out.println(person.toString());*/

        String num="你好";
        testParam1(num);
        System.out.println(num);


    }

    @Test
    public void fun02() {
        fun01();
        System.out.println("你好");
    }

    public void testParam(Person person){
        person.setName("小红");
        person.setAge(16);
        //System.out.println(person.toString());
    }

    public void testParam1(String num){
        num="hello";
        //System.out.println(person.toString());
    }
}
