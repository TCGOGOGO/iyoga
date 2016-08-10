package com.asiainfo.iyoga.service;

import com.asiainfo.iyoga.bean.Card;
import com.asiainfo.iyoga.bean.Member;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by tcgogogo on 16/8/10.
 */

public interface MemberService {
    public boolean findDuplicateMember(String name) throws IOException, SQLException;
    public void writeToMember(Member member) throws SQLException, IOException;
}
