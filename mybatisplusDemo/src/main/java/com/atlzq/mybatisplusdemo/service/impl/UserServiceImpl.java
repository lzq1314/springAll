package com.atlzq.mybatisplusdemo.service.impl;

import com.atlzq.mybatisplusdemo.entity.User;
import com.atlzq.mybatisplusdemo.mapper.UserMapper;
import com.atlzq.mybatisplusdemo.service.UserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
