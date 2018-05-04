package com.testcase.plaintest.security.mapper;

import com.testcase.plaintest.security.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysMenu record);

    SysMenu selectByPrimaryKey(String id);

    List<SysMenu> selectAll();

    int updateByPrimaryKey(SysMenu record);
}