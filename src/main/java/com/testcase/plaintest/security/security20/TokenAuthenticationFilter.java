package com.testcase.plaintest.security.security20;/*
package com.landz.landzauth2.common.security;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TokenAuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        final String token = httpRequest.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            String username = Jwts.parser()
                    .setSigningKey(LoginSuccessHandler.SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            if (username!= null) {
                log.info(String.format("User login in with user name: %s", username));
                new UsernamePasswordAuthenticationToken(username, "", Lists.<GrantedAuthority>newArrayList());
            }
        }
        return null;
    }

    @Override
    public void destroy() {

    }
}
*/
