package com.yu.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yu.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Component
public class JwtFilter extends AuthenticatingFilter {
    @Autowired
    JwtUtils jwtUtils;
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        // 获取 token
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String jwt = request.getHeader("Authorization");
        if(StringUtils.isEmpty(jwt)){
            return null;
        }
        return new JwtToken(jwt);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String token = servletRequest.getHeader("Authorization");

        if(StringUtils.isEmpty(token)) {
            return true;
        } else {
            // 判断是否已过期
            Claims claim = jwtUtils.getClaimByToken(token);
            if(claim == null || jwtUtils.isTokenExpired(claim.getExpiration())) {
                throw new ExpiredCredentialsException("token已失效，请重新登录！");
            }
        }
        return executeLogin(request, response);
    }
//    /**
//     * 对跨域提供支持
//     */
//    @Override
//    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
//        HttpServletRequest httpRequest = WebUtils.toHttp(request);
//        HttpServletResponse httpResponse = WebUtils.toHttp(response);
//        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            httpResponse.setHeader("Access-control-Allow-Origin", httpRequest.getHeader("Origin"));
//            httpResponse.setHeader("Access-Control-Allow-Methods", httpRequest.getMethod());
//            httpResponse.setHeader("Access-Control-Allow-Headers", httpRequest.getHeader("Access-Control-Request-Headers"));
//            httpResponse.setStatus(HttpStatus.OK.value());
//            return false;
//        }
//        return super.preHandle(request, response);
//    }
}
