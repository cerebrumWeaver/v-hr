package org.javaboy.vhr.config;

import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 这个类的作用，主要是根据用户传来的请求地址，分析出请求需要的角色
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();                                                               //实现ant风格的URL匹配
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {                   //该方法的参数（object）是一个FilterInvocation
        String requestUrl = ((FilterInvocation) object).getRequestUrl();                                                //开发者可以从FilterInvocation中提取出当前请求的URL
        List<Menu> menus = menuService.getAllMenusWithRole();     //可以将提取的数据库（即返回值）的资源信息缓存在在Redis     //根据查询条件获取诸多Menu实体
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {                                                      //若当前请求的页面   满足   当前角色权限
                List<Role> roles = menu.getRoles();                                                                     //获取Role表中的诸多角色
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();                                                                    //获取Role表中的诸多角色的name
                }
                return SecurityConfig.createList(str);                                                                  //返回请求需要的诸多角色
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override               //此方法返回所有定义好的资源，Spring Security在启动时会校验相关配置是否正确，如果不需要校验，那么该方法直接返回null即可
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override               //返回类对象是否支持校验
    public boolean supports(Class<?> clazz) {                                                                           //该方法返回类对象是否“支持”校验
        return true;
    }
}
