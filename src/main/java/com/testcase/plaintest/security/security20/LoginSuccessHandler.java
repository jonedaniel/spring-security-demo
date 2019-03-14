package com.testcase.plaintest.security.security20;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * 登录成功处理器
 *
 * @author zhaomenghui
 * @createDate 2019/3/13
 */
@Slf4j
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

   /* @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        User                         user        = (User) authentication.getPrincipal();
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        //输出登录提示信息
        log.warn("用户 " + user.getUsername() + " 登录成功，" + "IP :" + UserContext.getIpAddress(request));
        log.warn("authorities:" + authorities);

        response.sendRedirect("user/success");
        super.onAuthenticationSuccess(request, response, authentication);
    }*/

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        JsonNodeFactory factory    = JsonNodeFactory.instance;
        ObjectNode      objectNode = factory.objectNode();
        objectNode.set("code", factory.textNode("200"));
        objectNode.set("status", factory.textNode("success"));
        objectNode.set("admin_token", factory.textNode(createToken(authentication)));
        PrintWriter out = response.getWriter();
        out.write(objectNode.toString());
        out.close();
    }

    private String createToken(Authentication authentication) {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
