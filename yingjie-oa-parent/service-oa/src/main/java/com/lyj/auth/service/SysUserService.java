package com.lyj.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyj.model.system.SysUser;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lyj
 * @since 2025-09-19
 */
public interface SysUserService extends IService<SysUser> {

    void updateStatus(Long id, Integer status);

    SysUser getUserByUserName(String username);

    Map<String, Object> getCurrentUser();

}
