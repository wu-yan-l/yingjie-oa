package com.lyj.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyj.auth.mapper.SysRoleMapper;
import com.lyj.auth.service.SysRoleService;
import com.lyj.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMpDemo2 {
    @Autowired
    private SysRoleService service;

    @Test
    public void getAll() {
        List<SysRole> list = service.list();
        System.out.println(list);
    }

}
