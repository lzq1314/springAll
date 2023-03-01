package com.atlzq.mybatisplusdemo;

import com.atlzq.mybatisplusdemo.entity.User;
import com.atlzq.mybatisplusdemo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisPlusServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getCount(){
        //查询总记录数
        /*long count = userService.count(new LambdaQueryWrapper<>());
        System.out.println(count);*/

    }

    @Test
    public void saveBatch(){
        //批量添加
        List<User> userList = new ArrayList<>();
        for (int i=0;i<10;i++){
            User user = new User();
            user.setName("lzq"+i);
            user.setAge(20+i);
            user.setEmail(user.getName()+"@qq.com");
            userList.add(user);
        }
        boolean b = userService.saveBatch(userList);
        System.out.println(b);
    }
}
