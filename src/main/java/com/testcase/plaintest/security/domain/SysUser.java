package com.testcase.plaintest.security.domain;

import com.testcase.plaintest.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser extends BaseModel implements UserDetails {
    private String        username;
    private String        password;
    private Integer       age;
    private String        email;
    private String        photo;
    private String        realName;
    private String        createBy;
    private String        updateBy;
    private Date          createDate;
    private Date          updateDate;
    private String        delFlag;
    private List<SysRole> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}