package com.asiainfo.iyoga.test;

import com.asiainfo.iyoga.common.MysqlConnect;
import org.junit.Test;
import java.io.IOException;
import java.sql.Connection;
import static org.junit.Assert.assertNull;

/**
 * Created by tcgogogo on 16/8/10.
 */

public class MysqlConnectTest {
    private static Connection conn = null;
    @Test
    public static void MysqlConnTest() throws IOException {
        conn = MysqlConnect.getConnet();
        assertNull(conn);
    }
}
