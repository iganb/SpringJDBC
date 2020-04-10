package com.zhongruan.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 张驰
 * @date 2020-03-19 10:50
 */
public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Student(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("sex"),
                resultSet.getInt("age"));
    }
}
