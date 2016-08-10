package com.asiainfo.iyoga.service;

import com.asiainfo.iyoga.bean.Card;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by tcgogogo on 16/8/10.
 */

public interface CardService {
    public boolean findMemberName(String name) throws IOException;

    public void writeToCard(String name, Card card) throws SQLException, IOException;
}
