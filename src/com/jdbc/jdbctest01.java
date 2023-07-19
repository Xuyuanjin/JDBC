package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbctest01 {
    public static void main(String[] args) throws Exception {   //下面方法有不同的异常，我直接抛出一个大的异常

        //1、导入驱动jar包

        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3、获取数据库的连接对象（连接数据库test）
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");

        //4、定义sql语句
        //String sql = "update infor set name = '小风' where id = '1' "; //更新修改据库
        String sql = "insert into infor value(1,'李白',18)"; //在infor表插入一行数据


        //5、获取执行sql语句的对象
        Statement stat = con.createStatement();

        //6、执行sql并接收返回结果
        int count = stat.executeUpdate(sql);

        //7、处理结果
        System.out.println("1为成功！0是失败！: "+count);

        //8、释放资源
        stat.close();
        con.close();
    }
}