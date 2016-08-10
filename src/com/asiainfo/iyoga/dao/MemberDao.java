package com.asiainfo.iyoga.dao;

import com.asiainfo.iyoga.bean.Member;
import com.asiainfo.iyoga.common.MysqlConnect;
import com.asiainfo.iyoga.common.StringScript;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class MemberDao {
    private static Connection conn = null;
    private static Statement statement = null;
    private static int result;
    private static String successMessage;
    private static ResultSet resultSet;
    private static String mysqlCode;

    private static Logger logger = Logger.getLogger(OpenDao.class);

    public static void writeToMysql(Member member) throws SQLException, IOException {
        logger.info("writeToMysql start");
        mysqlCode = "insert into member(name, address, job) values(?,?,?)";
        conn = MysqlConnect.getConnet();
        try (PreparedStatement ps = conn.prepareStatement(mysqlCode)) {
            ps.setString(1, member.getName());
            ps.setString(2, member.getAddress());
            ps.setString(3, member.getJob());
            result = ps.executeUpdate();
            if (result > 0) {
                statement = conn.createStatement();
                mysqlCode = "select max(id) from member";
                resultSet = statement.executeQuery(mysqlCode);
                int id = 0;
                while (resultSet.next()) {
                    id = Integer.parseInt(resultSet.getString(1));
                }
                resultSet.close();
                successMessage = "OK. " + member.getName() + "'s member id is " + StringScript.changeFormat(id) + ".";
                System.out.println(successMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.debug(e + "插入数据库失败");
            System.out.println("插入数据库失败");
        }
        logger.info("writeToMysql end");
    }

    public static boolean findDuplicate(String name) throws IOException, SQLException {
        logger.info("findDuplicate start");
        conn = MysqlConnect.getConnet();
        mysqlCode = "select *from member where name = " + "\"" + name + "\"";
        try (PreparedStatement ps = conn.prepareStatement(mysqlCode)) {
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                logger.info("findDuplicate end");
                return true;
            }
        }
        logger.info("findDuplicate end");
        return false;
    }
}
