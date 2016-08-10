package com.asiainfo.iyoga.serviceImpl;

import com.asiainfo.iyoga.dao.OpenDao;
import com.asiainfo.iyoga.service.OpenService;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class OpenServiceImpl implements OpenService{

    @Override
    public void writeToOpen(String name) throws SQLException, IOException {
        OpenDao.writeToMysql(name);
    }
}
