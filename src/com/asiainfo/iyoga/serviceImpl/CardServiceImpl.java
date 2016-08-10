package com.asiainfo.iyoga.serviceImpl;

import com.asiainfo.iyoga.bean.Card;
import com.asiainfo.iyoga.dao.CardDao;
import com.asiainfo.iyoga.service.CardService;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class CardServiceImpl implements CardService{

    @Override
    public boolean findMemberName(String name) throws IOException {
        return CardDao.findMember(name);
    }

    @Override
    public void writeToCard(String name, Card card) throws SQLException, IOException {
        CardDao.writeToMysql(name, card);
    }
}
