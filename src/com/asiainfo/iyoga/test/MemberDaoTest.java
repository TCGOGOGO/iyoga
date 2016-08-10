package com.asiainfo.iyoga.test;

import com.asiainfo.iyoga.bean.Member;
import com.asiainfo.iyoga.dao.MemberDao;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;
import static org.junit.Assert.*;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class MemberDaoTest {
    @Test
    public void memberTest() throws IOException, SQLException {
        MemberDao memberDao = new MemberDao();
        Member member = new Member("张三", "北京", "歌手");
        assertTrue(memberDao.findDuplicate("张三"));
        MemberDao.writeToMysql(member);
    }
}
