package com.xby.framework.security.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.xby.common.core.domain.model.LoginUser;
import com.xby.common.utils.SecurityUtils;
import com.xby.common.utils.StringUtils;
import com.xby.framework.web.service.TokenService;

/**
 * token过滤器 验证token有效性
 *
 * @author xby
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter
{
    @Autowired
    private TokenService tokenService;

    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        log.debug("001--JwtAuthenticationTokenFilter doFilterInternal,uri={}",request.getRequestURI());
        LoginUser loginUser = tokenService.getLoginUser(request);

        log.debug("002--JwtAuthenticationTokenFilter doFilterInternal,loginUser={}",loginUser);
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNull(SecurityUtils.getAuthentication()))
        {
            log.debug("003--JwtAuthenticationTokenFilter doFilterInternal");
            tokenService.verifyToken(loginUser);
            log.debug("004--JwtAuthenticationTokenFilter doFilterInternal");
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            log.debug("005--JwtAuthenticationTokenFilter doFilterInternal");
        }
        log.debug("006--JwtAuthenticationTokenFilter doFilterInternal");

        chain.doFilter(request, response);
        log.debug("007--JwtAuthenticationTokenFilter doFilterInternal");
    }
}
