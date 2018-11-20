package cn.wolfcode.service;

import cn.wolfcode.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RoleServiceTest {
    @Autowired
    private IRoleService iRoleService;
    @Test
    public void listAll() {
        List<Role> list = iRoleService.listAll();
        System.out.println(list);
    }}