package com.lyj.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyj.auth.service.SysMenuService;
import com.lyj.auth.service.SysUserService;
import com.lyj.common.config.exception.LyjException;
import com.lyj.common.jwt.JwtHelper;
import com.lyj.common.result.Result;
import com.lyj.common.utils.MD5;
import com.lyj.model.system.SysUser;
import com.lyj.vo.system.LoginVo;
import com.lyj.vo.system.RouterVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "后台登陆管理")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        String username = loginVo.getUsername();
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        if (sysUser == null) {
            throw new LyjException(201, "用户不存在");
        }
        String password_db = sysUser.getPassword();
        String password_input = MD5.encrypt(loginVo.getPassword());
        if (!password_db.equals(password_input)) {
            throw new LyjException(201, "密码错误");
        }
        if (sysUser.getStatus() == 0) {
            throw new LyjException(201, "用户被禁用");
        }
        String token = JwtHelper.createToken(sysUser.getId(), sysUser.getUsername());
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return Result.ok(map);
    }

    @GetMapping("/info")
    public Result info(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long userId = JwtHelper.getUserId(token);
        SysUser sysUser = sysUserService.getById(userId);
        List<RouterVo> routerList = sysMenuService.findUserMenuListByUserId(userId);
        List<String> permsList = sysMenuService.findUserPermsByUserId(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("name", sysUser.getName());
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");

        map.put("routers", routerList);
        map.put("buttons", permsList);
        return Result.ok(map);
    }

    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }
}
