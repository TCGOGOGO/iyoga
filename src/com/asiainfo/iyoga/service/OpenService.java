package com.asiainfo.iyoga.service;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by tcgogogo on 16/8/10.
 */
@FunctionalInterface
public interface OpenService {
    public void writeToOpen(String name) throws SQLException, IOException;
}
