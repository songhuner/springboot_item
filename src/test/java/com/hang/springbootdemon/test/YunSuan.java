package com.hang.springbootdemon.test;

import org.junit.Test;

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
}
