package com.hang.springbootdemon.test;

import org.junit.Test;

import java.sql.SQLOutput;

/**
 * @author huangjh
 * @date 2021/6/3
 * 查看内存
 */
public class MemoryQry {
    @Test
    public void fun01(){
        Runtime run = Runtime.getRuntime();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usableMemony = maxMemory - totalMemory + freeMemory;

        System.out.println("最大可用内存是："+ maxMemory/1024/1024 + "M");//对应-Xmx
        System.out.println("已分配到的内存大小是："+ totalMemory/1024/1024 + "M");//当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
        System.out.println("所分配内存的剩余大小是："+ freeMemory/1024/1024 + "M");//当前JVM空闲内存
        System.out.println("最大可用内存大小是："+ usableMemony/1024/1024 + "M");
    }

}
