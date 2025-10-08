package com.lyj.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyj.model.system.SysRole;
import com.lyj.vo.system.AssignRoleVo;

import java.util.Map;

public interface SysRoleService extends IService<SysRole> {
    Map<String, Object> findRoleDataByUserId(Long userId);

    void doAssign(AssignRoleVo assignRoleVo);
}
