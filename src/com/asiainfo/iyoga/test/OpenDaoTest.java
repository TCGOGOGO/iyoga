package com.asiainfo.iyoga.test;

import com.asiainfo.iyoga.bean.Card;
import com.asiainfo.iyoga.dao.CardDao;
import com.asiainfo.iyoga.dao.OpenDao;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;
import static org.junit.Assert.*;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class OpenDaoTest {
    @Test
    public void OpenTest() throws IOException, SQLException {
        OpenDao openDao = new OpenDao();
        CardDao cardDao = new CardDao();
        Card card = new Card("年卡", "2016-1-1", "2017-1-1", 0);
        assertFalse(cardDao.findMember("张三"));
        openDao.writeToMysql("张三");
    }
}
