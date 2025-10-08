package com.lyj.wechat.controller;


import com.lyj.common.result.Result;
import com.lyj.model.wechat.Menu;
import com.lyj.vo.wechat.MenuVo;
import com.lyj.wechat.service.WechatMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author lyj
 * @since 2025-09-29
 */
@RestController
@RequestMapping("/admin/wechat/menu")
public class WechatMenuController {
    @Autowired
    private WechatMenuService wechatMenuService;

    @ApiOperation(value = "删除菜单")
    @DeleteMapping("removeMenu")
    public Result removeMenu() {
        wechatMenuService.removeMenu();
        return Result.ok();
    }

    @ApiOperation(value = "同步菜单")
    @GetMapping("/syncMenu")
    public Result createMenu() {
        wechatMenuService.syncMenu();
        return Result.ok();
    }

    //@PreAuthorize("hasAuthority('bnt.menu.list')")
    @ApiOperation(value = "获取")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable Long id) {
        Menu menu = wechatMenuService.getById(id);
        return Result.ok(menu);
    }

    //@PreAuthorize("hasAuthority('bnt.menu.add')")
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody Menu menu) {
        wechatMenuService.save(menu);
        return Result.ok();
    }

    //@PreAuthorize("hasAuthority('bnt.menu.update')")
    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public Result updateById(@RequestBody Menu menu) {
        wechatMenuService.updateById(menu);
        return Result.ok();
    }

    //@PreAuthorize("hasAuthority('bnt.menu.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        wechatMenuService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "获取全部菜单")
    @GetMapping("/findMenuInfo")
    public Result findMenuInfo() {
        List<MenuVo> menuVoList = wechatMenuService.findMenuInfo();
        return Result.ok(menuVoList);
    }
}

