package com.hang.springbootdemon.test;

import com.hang.springbootdemon.entity.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 泛型
 * @author huangjh
 * @date 2020/8/25
 */
public class FanXingTest {
    @Test
    public void fun01(){
        List<String> strings = Arrays.asList(new String[]{"a", "b"});
        String listElement = getListElement(strings);
        System.out.println(listElement);
    }
    public <T> T getListElement(List<T> list){
        if (list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
