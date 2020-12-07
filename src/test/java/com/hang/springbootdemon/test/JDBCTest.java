package com.hang.springbootdemon.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.*;
import java.util.concurrent.*;

/**
 * @author huangjh
 * @date 2020/12/7
 */
public class JDBCTest {
    /**
     * 执行查询sql
     *
     * @throws Exception
     */
    @Test
    public void executeSelect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myitemdb", "root", "root");
        Statement statement = connection.createStatement();
        String sql = "select * from person";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet.toString());
    }

    /**
     * 批量插入数据
     *
     * @throws Exception
     */
    @Test
    public void executeBatchInsert() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myitemdb", "root", "root");
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("insert into person values(null,?,?,? )");
            long start = System.currentTimeMillis();
            //总数
            int sum = 25001;
            //批次条数
            int batchNum = 1000;
            //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 100, 5l, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5));
            for (int i = 0; i < sum; i++) {
                preparedStatement.setString(1, "夏小明" + i);
                preparedStatement.setInt(2, i);
                preparedStatement.setBigDecimal(3, BigDecimal.valueOf(1.2333));
                preparedStatement.addBatch();
                //批次提交执行
                if (i != 0 && i % sum == 0) {
                    preparedStatement.executeBatch();//加线程
                    preparedStatement.clearBatch();

                }

            }
            //执行余数
            if ((sum % batchNum) != 0) {
                int[] ints = preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
            connection.commit();

            long end = System.currentTimeMillis();
            System.out.println("耗费时间：" + (end - start) + "ms");
            //threadPoolExecutor.shutdown();
        } catch (Exception e) {
            //异常回滚
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            //关闭资源
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    @Test
    public void executeBatchInsertWithThread() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myitemdb", "root", "root");
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("insert into person values(null,?,?,? )");
            long start = System.currentTimeMillis();
            //总数
            int sum = 20025;
            //批次条数
            int batchNum = 100;
            //转换double
            double sumD = Double.parseDouble("" + sum);
            double batchNumD = Double.parseDouble("" + batchNum);
            //线程数
            double threadNum = Math.floor(sumD / batchNumD);
            final CountDownLatch latch = new CountDownLatch(200);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, Integer.MAX_VALUE, 0l, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
            for (int i = 0; i < sum; i++) {
                preparedStatement.setString(1, "夏小明" + i);
                preparedStatement.setInt(2, i);
                preparedStatement.setBigDecimal(3, BigDecimal.valueOf(1.2333));
                preparedStatement.addBatch();
                //批次提交执行
                if (i != 0 && i % batchNum == 0) {
                    threadSys(threadPoolExecutor,preparedStatement,latch);
                }

            }
            latch.await();
            //执行余数
            if ((sum % batchNum) != 0) {
                int[] ints = preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
            connection.commit();

            long end = System.currentTimeMillis();
            System.out.println("耗费时间：" + (end - start) + "ms");
            threadPoolExecutor.shutdown();
        } catch (Exception e) {
            System.out.println("异常信息是："+e.toString()+"-------end-");
            e.printStackTrace();
            //异常回滚
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            //关闭资源
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    public void threadSys(ThreadPoolExecutor threadPoolExecutor, PreparedStatement preparedStatement,CountDownLatch latch) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
                latch.countDown();

            }
        });
    }

}
