package com.zhongruan.service.impl;

import com.zhongruan.bean.Student;
import com.zhongruan.dao.IStudentDao;
import com.zhongruan.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import java.util.List;

/**
 * @author 张驰
 * @date 2020-03-18 16:06
 */
@Service
public class IStudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao dao;


    @Override
    public boolean addStudent(Student student) {
        return dao.addStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return dao.deleteStudent(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return dao.updateStudent(student);
    }

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Student> findAllById(int id) {
        return dao.findAllById(id);
    }

    @Override
    public List<Student> findLike(String name) {
        return dao.findLike(name);
    }
}
