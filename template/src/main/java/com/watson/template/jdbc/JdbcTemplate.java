package com.watson.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values){
        List<?> result = null;
        try {
            //1获取连接
            Connection connection = this.getConnection();
            //2创建语句集
            PreparedStatement ps = this.createPreparedStatement(connection,sql);
            //3执行语句集
            ResultSet rs = this.executeQuery(ps, values);
            //4处理结果集
            result = this.parseResultSet(rs, rowMapper);
            //5关闭结果集
            this.closeResultSet(rs);
            //6关闭语句集
            this.closeStatement(ps);
            //7关闭连接
            this.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    protected void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    protected void closeStatement(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    protected  void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    protected List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement ps, Object[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            ps.setObject(i, values[i]);
        }
        return ps.executeQuery();
    }

    private PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
