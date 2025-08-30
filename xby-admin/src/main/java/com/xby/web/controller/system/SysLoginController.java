package com.xby.web.controller.system;

import java.util.List;
import java.util.Set;

import com.xby.common.annotation.Anonymous;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.xby.common.constant.Constants;
import com.xby.common.core.domain.AjaxResult;
import com.xby.common.core.domain.entity.SysMenu;
import com.xby.common.core.domain.entity.SysUser;
import com.xby.common.core.domain.model.LoginBody;
import com.xby.common.core.domain.model.LoginUser;
import com.xby.common.utils.SecurityUtils;
import com.xby.framework.web.service.SysLoginService;
import com.xby.framework.web.service.SysPermissionService;
import com.xby.framework.web.service.TokenService;
import com.xby.system.service.ISysMenuService;

/**
 * 登录验证
 *
 * @author xby
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    private static final Logger log = LoggerFactory.getLogger(SysLoginController.class);


    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @Anonymous
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        log.info("getInfo() method called");
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        if (!loginUser.getPermissions().equals(permissions))
        {
            loginUser.setPermissions(permissions);
            tokenService.refreshToken(loginUser);
        }
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        log.info("getRouters() method called");
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
