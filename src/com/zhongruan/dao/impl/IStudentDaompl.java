package com.zhongruan.dao.impl;

import com.zhongruan.bean.Student;
import com.zhongruan.bean.StudentRowMapper;
import com.zhongruan.dao.IStudentDao;
import com.zhongruan.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张驰
 * @date 2020-03-18 15:59
 */
@Repository
public class IStudentDaompl implements IStudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //注入方法
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean addStudent(Student student) {
        boolean flag=false;
        String sql="insert into tb_student value(?,?,?,?)";
        int row=jdbcTemplate.update(sql,student.getId(),student.getName(),student.getSex(),student.getAge());
        if (row>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean flag=false;
        String sql="delete  from tb_student where id=?";
        int row=jdbcTemplate.update(sql,id);
        if (row>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean flag=false;
        String sql="update tb_student set name=?,sex=?,age=? where id=?";
        int row=jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getAge(),student.getId());
        if (row>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public List<Student> findAll() {

        String sql="select * from tb_student";
        List<Student> list=jdbcTemplate.query(sql,new StudentRowMapper());

        return list;
    }

    @Override
    public List<Student> findAllById(int id) {
        String sql="select * from tb_student where id=?";
        Object[] objects={id};
        List<Student> list=jdbcTemplate.query(sql,objects,new StudentRowMapper());

        return list;
    }

    @Override
    public List<Student> findLike(String name) {
        String sql="select * from tb_student where name like ?";
        Object[] objects={"%"+name+"%"};
        List<Student> list=jdbcTemplate.query(sql,objects,new StudentRowMapper());

        return list;
    }
}
