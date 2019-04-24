package com.watson.template.jdbc.dao;

import com.watson.template.jdbc.JdbcTemplate;
import com.watson.template.jdbc.Member;
import com.watson.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JdbcTemplate {
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }
    public List<?> selectAll(){
        String sql = "select * from t_member";
        return executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setName(rs.getString("username"));
                member.setName(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        },null);
    }
}
