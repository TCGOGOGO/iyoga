package com.asiainfo.iyoga.dao;

import com.asiainfo.iyoga.common.MysqlConnect;
import com.asiainfo.iyoga.common.StringScript;
import com.asiainfo.iyoga.bean.Card;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.sql.*;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class CardDao {
    private static Connection conn = null;
    private static Statement statement = null;
    private static int result = 0;
    private static String mysqlCode = "";
    private static String successMessage = "";
    private static ResultSet resultSet = null;
    private static Logger logger = Logger.getLogger(CardDao.class);

    public static void  writeToMysql(String name, Card card) throws SQLException, IOException {
        logger.info("writeToMysql start");
        mysqlCode = "insert into card(type, startTime, endTime, times) values(?,?,?,?)";
        if(conn == null)
            conn = MysqlConnect.getConnet();
        try (PreparedStatement ps = conn.prepareStatement(mysqlCode.toString())) {
            ps.setString(1, card.getType());
            ps.setString(2, card.getStartTime());
            ps.setString(3, card.getEndTime());
            ps.setInt(4, card.getTimes());
            result = ps.executeUpdate();
            if (result > 0) {
                statement = conn.createStatement();
                //mysqlCode: select id from member where name = "name"
                mysqlCode = "select id from member where name = " + "\"" + name + "\"";
                resultSet = statement.executeQuery(mysqlCode.toString());
                int id = 0;
                while (resultSet.next()) {
                    id = Integer.parseInt(resultSet.getString(1));
                }
                resultSet.close();
                if("年卡".equals(card.getType())) {
                    //success example: A new 年卡 added to 三傻(001).
                    successMessage = "A new 年卡 added to " + name + "(" + StringScript.changeIdFormat(id) + ").";
                }
                else if("次卡".equals(card.getType())) {
                    //success example: A 次卡 with 100 times added to 三傻.
                    successMessage = "A new 次卡 with " + card.getTimes() + " times added to " + name + ".";
                }
                System.out.println(successMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.debug(e + "插入数据库失败");
        }
        logger.info("writeToMysql end");
    }

    public static boolean findMember(String name) throws IOException {
        logger.info("findMember start");
        if(conn == null)
            conn = MysqlConnect.getConnet();
        //mysqlCode: select *from member where name = "name"
        mysqlCode = "select *from member where name = " + "\"" + name + "\"";
        try (PreparedStatement ps = conn.prepareStatement(mysqlCode.toString())) {
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                logger.info("findMember end");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.debug(e);
        }
        logger.info("findMember end");
        return false;
    }
}
