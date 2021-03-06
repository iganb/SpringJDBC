package com.zhongruan.dao;

import com.zhongruan.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张驰
 * @date 2020-03-18 15:55
 */

public interface IStudentDao {

    //增加学生
    public boolean addStudent(Student student);

    //根据id删除学生
    boolean deleteStudent(int id);

    //更新
    boolean updateStudent(Student student);

    //查询全部
    List<Student> findAll();
    //查询id
    List<Student> findAllById(int id);
    //模糊查询name
    List<Student> findLike(String name);
}
