package org.javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {        //当一个FilterInvocationSecurityMetadataSource的getAttributes方法走完，
    @Override                                                                   //接下来会来到AccessDecisionManager类中进行角色信息比对
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : configAttributes) {              //decide三个参数----  1：当前登录用户信息；2：FilterInvocation对象，即通过它可以提取当前请求的URL；
            String needRole = configAttribute.getAttribute();                   //3：FilterInvocationSecurityMetadataSource中的getAttributes方法返回值，即当前请求URL所需的角色
            if ("ROLE_LOGIN".equals(needRole)) {                                //如果所需角色为ROLE_LOGIN,表明请求的URL用户登录后方可访问
                if (authentication instanceof AnonymousAuthenticationToken) {   //如果所需角色authentication不是匿名用户的实例（AnonymousAuthenticationToken），表示当前用户已登录
                    throw new AccessDeniedException("您还没登录吧，请登录!");
                }else {
                    return;
                }
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();                       //获取当前   登录用户   的角色信息
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员!");               //如果用户不具备当前请求的URL所需角色信息，抛出此异常
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
