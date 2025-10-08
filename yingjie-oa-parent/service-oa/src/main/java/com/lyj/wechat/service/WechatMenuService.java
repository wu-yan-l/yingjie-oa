package com.lyj.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyj.model.wechat.Menu;
import com.lyj.vo.wechat.MenuVo;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author lyj
 * @since 2025-09-29
 */
public interface WechatMenuService extends IService<Menu> {

    List<MenuVo> findMenuInfo();

    void syncMenu();

    void removeMenu();

}
