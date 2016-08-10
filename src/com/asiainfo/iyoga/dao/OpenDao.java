package com.asiainfo.iyoga.dao;

import com.asiainfo.iyoga.common.MysqlConnect;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class OpenDao {
    private static Connection conn = null;
    private static Statement statement = null;
    private static ResultSet resultSet;

    private static Logger logger = Logger.getLogger(OpenDao.class);

    public static void writeToMysql(String name) throws SQLException, IOException {
        logger.info("writeToMysql start");
        conn = MysqlConnect.getConnet();
        statement = conn.createStatement();
        String mysqlCode = "select id from member where name = " + "\"" + name + "\"";
        resultSet = statement.executeQuery(mysqlCode);
        int memberId = 0;
        while (resultSet.next()) {
            memberId = Integer.parseInt(resultSet.getString(1));
        }
        resultSet.close();
        resultSet = statement.executeQuery("select max(id) from card");
        int cardId = 0;
        while (resultSet.next()) {
            cardId = Integer.parseInt(resultSet.getString(1));
        }
        System.out.println("mem = " + memberId + " card = " + cardId);
        resultSet.close();
        mysqlCode = "insert into open(member_id, card_id) values(?,?)";
        try (PreparedStatement ps = conn.prepareStatement(mysqlCode)) {
            ps.setInt(1, memberId);
            ps.setInt(2, cardId);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.debug(e + "插入数据库失败");
            System.out.println("插入数据库失败");
        }
        logger.info("writeToMysql end");
    }
}
