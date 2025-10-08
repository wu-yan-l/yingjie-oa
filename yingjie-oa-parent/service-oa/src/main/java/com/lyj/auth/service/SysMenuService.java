package com.lyj.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyj.model.system.SysMenu;
import com.lyj.vo.system.AssignMenuVo;
import com.lyj.vo.system.RouterVo;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author lyj
 * @since 2025-09-20
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> findNodes();

    void removeMenuById(Long id);

    List<SysMenu> findMenuByRoleId(Long roleId);

    void doAssign(AssignMenuVo assignMenuVo);

    List<RouterVo> findUserMenuListByUserId(Long userId);

    List<String> findUserPermsByUserId(Long userId);
}
