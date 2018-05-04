package com.testcase.plaintest.security;

import com.testcase.plaintest.security.domain.SysRole;
import com.testcase.plaintest.security.domain.SysUser;
import com.testcase.plaintest.security.mapper.SysUserMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Resource
    private SysUserMapper userMapper;

    /**
     * 数据库交互获取用户拥有的权限角色，并设置权限
     */
    @Override
    public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException, DataAccessException {
        // 根据登录用户名获取用户信息
        SysUser user = new SysUser();
        user = userMapper.selectUserByUsername(userCode);
        if (null != user) {
            // 存放权限
            Collection<GrantedAuthority> auths  = new ArrayList<GrantedAuthority>();
            List<SysRole>                roles  = user.getRoles();
            if (roles.size()>0) {
                for (int i = 0; i < roles.size(); i++) {
                    SimpleGrantedAuthority auth = new SimpleGrantedAuthority(roles.get(i).getRoleName());
                    auths.add(auth);
                }
            }
            //spring security自带的User对象
            User userDetails = new User(userCode, user.getPassword(), true, true, true, true, auths);
            return userDetails;
        }
        return null;
    }
}