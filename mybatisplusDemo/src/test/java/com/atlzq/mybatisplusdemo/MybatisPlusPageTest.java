package com.atlzq.mybatisplusdemo;

import com.atlzq.mybatisplusdemo.mapper.UserMapper;
import com.atlzq.mybatisplusdemo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusPageTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void serlectByPage(){
        Page page = new Page(1,3);
        Page pageList = userMapper.selectPage(page, null);
        System.out.println(pageList);
        System.out.println(pageList.getRecords());
        System.out.println(pageList.getCurrent());
    }

    @Test
    public void customSelectPage(){
        Page page = new Page(1,3);
        Page pageList = userMapper.selectPageVo(page, 10);
        System.out.println(pageList);
        System.out.println(pageList.getRecords());
        System.out.println(pageList.getCurrent());
    }
    @Test
    public void lambdaSerlectByPage(){
        LambdaQueryWrapper queryWrapper = new LambdaQueryWrapper();
        Page page = new Page(1,3);
        Page pageList = userService.page(page,null);
        System.out.println(pageList);
        System.out.println(pageList.getRecords());
        System.out.println(pageList.getCurrent());
    }

}
