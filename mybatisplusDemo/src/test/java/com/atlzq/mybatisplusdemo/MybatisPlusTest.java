package com.atlzq.mybatisplusdemo;

import com.atlzq.mybatisplusdemo.entity.User;
import com.atlzq.mybatisplusdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectListTest(){
        List<User> users = userMapper.selectList(new LambdaQueryWrapper<>());
        users.forEach(System.out::println);
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setName("lzq");
        user.setAge(18);
        user.setEmail("112@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void selectTest(){
         //通过id查询用户信息
        /*User user = userMapper.selectById(1L);
        System.out.println(user);*/
        //批量查询
        /*List<Long> ids = Arrays.asList(1L,2L,3L);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);*/
        //根据map中的条件查询
        /*Map<String,Object> map = new HashMap<>();
        map.put("name","jack");
        map.put("age",20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);*/
        //自定义UserMapper.xml查询
        /*Map map = userMapper.selectMapById(1L);
        System.out.println(map);*/
    }
}
