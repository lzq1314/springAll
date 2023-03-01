package com.atlzq.mybatisplusdemo.mapper;

import com.atlzq.mybatisplusdemo.entity.User;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@DS("master")
@Repository
public interface UserMapper extends BaseMapper<User> {
    Map<String, Object> selectMapById(long l);

    //通过年龄查询用户信息并分页
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
}
