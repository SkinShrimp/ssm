package cn.wolfcode.service;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.query.EmployeeQueryObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {
    @Autowired
    private IEmployeeService employeeService;
    @Test
    public void save() {
        //Employee entry = new Employee(null, "张三", "123456", "123@qq.com", 12, true, 1L);
       // employeeService.save(entry);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {
    }

    @Test
    public void listAll() {
    }

    @Test
    public void query() {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setKeyWord("张三");
        System.out.println(employeeService.query(qo));
    }
}