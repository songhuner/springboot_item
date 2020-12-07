package com.hang.springbootdemon.test;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjh
 * @date 2020/12/8
 */
public class YunSuan {
    /**
     * 除法取整
     */
    @Test
    public void chuFa(){
        double a=9;
        double b=7;
        double c=a/b;
        //向上取整
        double ceil = Math.ceil(c);
        //向下取整
        double floor = Math.floor(c);

        System.out.println(c);

    }

    @Test
    public void fun01(){
        int a=9;
        int b=4;
        double v = Double.parseDouble(a + "");
        double v1 = Double.parseDouble(b + "");
        double floor = Math.ceil(v/v1);
        System.out.println(floor);
        ExecutorService es = Executors.newFixedThreadPool(4);

    }
    @Test
    public void fun02(){
        Long a = 10l;
        int b=a.intValue();

    }
}
