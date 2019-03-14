package com.testcase.plaintest.security.security20;

import com.landz.landzauth2.common.to.LoginUserTo;
import com.landz.landzauth2.mapper.read.UserReadMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录逻辑
 *
 * @author zhaomenghui
 * @createDate 2019/3/13
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Resource
    private UserReadMapper userReadMapper;

    /**
     * 数据库交互获取用户拥有的权限角色，并设置权限
     */
    @Override
    public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException, DataAccessException {
        // 根据登录用户名获取用户信息
        LoginUserTo user = userReadMapper.selectUserListWithRoleByUserCode(userCode);
      /*  if (null != user) {
            //返回spring security自带的User对象
            return new User(userCode, user.getUserPwd(), true, true, true, true, user.getAuthorities());
        }*/
        return null;
    }
}