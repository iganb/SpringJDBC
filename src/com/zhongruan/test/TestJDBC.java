package com.zhongruan.test;

import com.zhongruan.bean.Student;
import com.zhongruan.service.IStudentService;
import com.zhongruan.service.impl.IStudentServiceImpl;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * @author 张驰
 * @date 2020-03-18 16:08
 */

public class TestJDBC {
    private Scanner sc=new Scanner(System.in);

    private ApplicationContext ac;

    @Before
    public void into(){
        ac=new ClassPathXmlApplicationContext("applicationContext.xml");

    }

    @Test
    public void testAddStu(){
        //1.给定学生信息
        Student student=new Student(2,"李四","女",20);
        //2.调用service进行测试
        IStudentServiceImpl ssi= (IStudentServiceImpl) ac.getBean("IStudentServiceImpl");
        boolean b=ssi.addStudent(student);
        if (b){
            System.out.println("增加成功");
        }else {
            System.out.println("增加失败");
        }
    }
    @Test
    public void testDeleteStu(){
        System.out.println("请输入要删除的学生id");
        int id =sc.nextInt();
        IStudentServiceImpl ssi= (IStudentServiceImpl) ac.getBean("IStudentServiceImpl");
        boolean b=ssi.deleteStudent(id);
        if (b){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
    @Test
    public void testUpdateStu(){
        //1.给定学生信息
        Student student=new Student(9,"四s","女",28);
        //2.调用service进行测试
        IStudentServiceImpl ssi= (IStudentServiceImpl) ac.getBean("IStudentServiceImpl");
        boolean b=ssi.updateStudent(student);
        if (b){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }
    @Test
    public void testFindAll(){
        IStudentServiceImpl ssi= (IStudentServiceImpl) ac.getBean("IStudentServiceImpl");
        List<Student> student=ssi.findAll();
        for (Student s : student) {
            System.out.println(s.toString());
        }
    }
    @Test
    public void testFindAllById(){
        IStudentServiceImpl ssi= (IStudentServiceImpl) ac.getBean("IStudentServiceImpl");
        int id=1;
        List<Student> student=ssi.findAllById(id);
        for (Student s : student) {
            System.out.println(s.toString());
        }
    }
    @Test
    public void testFindLike(){
        IStudentServiceImpl ssi= (IStudentServiceImpl) ac.getBean("IStudentServiceImpl");
        String name="李";
        List<Student> student=ssi.findLike(name);
        for (Student s : student) {
            System.out.println(s.toString());
        }
    }

}
