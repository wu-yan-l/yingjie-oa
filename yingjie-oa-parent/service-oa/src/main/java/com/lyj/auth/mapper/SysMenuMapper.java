package com.lyj.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyj.model.system.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author lyj
 * @since 2025-09-20
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> findMenuListByUserId(@Param("userId") Long userId);
}
