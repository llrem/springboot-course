package com.yu.config;

import com.yu.entity.user;
import com.yu.service.userService;
import com.yu.utils.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class userRealm extends AuthorizingRealm {
    @Autowired
    userService userService;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        user user = userService.getById(username);
        if(user == null) {
            throw new UnknownAccountException(); //没找到帐号
        }
        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
    }
}
