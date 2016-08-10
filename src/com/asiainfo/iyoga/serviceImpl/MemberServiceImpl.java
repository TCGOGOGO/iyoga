package com.asiainfo.iyoga.serviceImpl;

import com.asiainfo.iyoga.bean.Member;
import com.asiainfo.iyoga.dao.MemberDao;
import com.asiainfo.iyoga.service.MemberService;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class MemberServiceImpl implements MemberService {

    @Override
    public boolean findDuplicateMember(String name) throws IOException, SQLException {
        return MemberDao.findDuplicate(name);
    }

    @Override
    public void writeToMember(Member member) throws SQLException, IOException {
        MemberDao.writeToMysql(member);
    }
}
