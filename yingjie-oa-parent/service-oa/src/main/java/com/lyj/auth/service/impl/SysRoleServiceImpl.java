package com.lyj.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyj.auth.mapper.SysRoleMapper;
import com.lyj.auth.service.SysRoleService;
import com.lyj.auth.service.SysUserRoleService;
import com.lyj.model.system.SysRole;
import com.lyj.model.system.SysUserRole;
import com.lyj.vo.system.AssignRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Override
    public Map<String, Object> findRoleDataByUserId(Long userId) {
        List<SysRole> allRolesList = baseMapper.selectList(null);

        LambdaQueryWrapper<SysUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserRole::getUserId, userId);
        List<SysUserRole> existUserRoleList = sysUserRoleService.list(lambdaQueryWrapper);

        List<Long> existRoleIdList = new ArrayList<>();
        for (SysUserRole sysUserRole : existUserRoleList) {
            Long roleId = sysUserRole.getRoleId();
            existRoleIdList.add(roleId);
        }

        List<SysRole> assginRoleList = new ArrayList<>();
        for (SysRole role : allRolesList) {
            if(existRoleIdList.contains(role.getId())) {
                assginRoleList.add(role);
            }
        }

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assignRoleList", assginRoleList);
        roleMap.put("allRolesList", allRolesList);
        return roleMap;
    }

    @Override
    public void doAssign(AssignRoleVo assignRoleVo) {
        LambdaQueryWrapper<SysUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserRole::getUserId, assignRoleVo.getUserId());
        sysUserRoleService.remove(lambdaQueryWrapper);

        List<Long> roleIdList = assignRoleVo.getRoleIdList();
        for (Long roleId : roleIdList) {
            if (StringUtils.isEmpty(roleId)) {
                continue;
            }
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assignRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleService.save(sysUserRole);
        }
    }
}
