package com.lyj.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyj.auth.mapper.SysRoleMapper;
import com.lyj.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMpDemo1 {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void getAll() {
        List<SysRole> list = sysRoleMapper.selectList(null);
        System.out.println(list);
    }

    @Test
    public void add() {
        SysRole role = new SysRole();
        role.setRoleName("角色管理员1");
        role.setRoleCode("role");
        role.setDescription("角色管理员1");

        int result = sysRoleMapper.insert(role);
        System.out.println(result);
        System.out.println(role.getId());
    }

    @Test
    public void update() {
        SysRole role = sysRoleMapper.selectById(10);
        role.setRoleName("lyj角色管理员");
        int update = sysRoleMapper.updateById(role);
        System.out.println(update);
    }

    @Test
    public void delete() {
        int result = sysRoleMapper.deleteById(10);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatchIds() {
        int result = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }

    @Test
    public void testQuery1() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_name", "角色管理员");
        List<SysRole> list = sysRoleMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    @Test
    public void testQuery2() {
        LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRole::getRoleName, "角色管理员");
        List<SysRole> list = sysRoleMapper.selectList(lambdaQueryWrapper);
        System.out.println(list);
    }
}
