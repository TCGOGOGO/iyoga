package com.asiainfo.iyoga.common;

import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by tcgogogo on 16/8/9.
 */
public class MysqlConnect {
    private static Connection conn;
    private static Logger logger = Logger.getLogger(MysqlConnect.class);

    private MysqlConnect() throws IOException {
        Properties prop = new Properties();
        FileInputStream fileIn = new FileInputStream("config.properties");
        prop.load(fileIn);
        String driver = prop.getProperty("driver");
        String myurl = prop.getProperty("myurl");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(myurl, user, password);
        } catch (SQLException e) {
            logger.debug(e + "MySQL操作错误");
        } catch (Exception e) {
            logger.debug(e);
        }
    }

    public static Connection getConnet() throws IOException {
        MysqlConnect mysqlConnect = new MysqlConnect();
        return mysqlConnect.conn;
    }
}