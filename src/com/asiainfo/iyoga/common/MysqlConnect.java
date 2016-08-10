package com.asiainfo.iyoga.common;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by tcgogogo on 16/8/9.
 */
public class MysqlConnect {
    private static Connection conn;

    public MysqlConnect() throws IOException {
        Properties prop = new Properties();
        FileInputStream fileIn = new FileInputStream("config.properties");
        prop.load(fileIn);
        String driver = prop.getProperty("driver").toString();
        String myurl = prop.getProperty("myurl").toString();
        String user = prop.getProperty("user").toString();
        String password = prop.getProperty("password").toString();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(myurl, user, password);
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnet() throws IOException {
        MysqlConnect mysqlConnect = new MysqlConnect();
        return mysqlConnect.conn;
    }
}