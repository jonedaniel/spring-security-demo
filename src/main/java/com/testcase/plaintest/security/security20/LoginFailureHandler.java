package com.testcase.plaintest.security.security20;

import com.alibaba.fastjson.JSON;
import com.landz.framework.core.model.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.landz.landzauth2.common.util.UserContext.getIpAddress;

/**
 * 登录失败处理器
 *
 * @author zhaomenghui
 * @createDate 2019/3/13
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {
    private static final Logger log = LoggerFactory.getLogger(LoginFailureHandler.class);


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.warn(">>> 登陆失败： "+"username:"+request.getParameter("username")+",password:"+request.getParameter("password"));
        log.warn(">>> ip："+getIpAddress(request));
        response.setStatus(200);
        response.setCharacterEncoding("utf-8");
        response.setContentType("json");
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(AjaxResponse.error("500","登录失败,请输入正确的账号密码")));
        writer.close();
    }

    }