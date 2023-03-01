package com.atlzq.mybatisplusdemo;

import com.atlzq.mybatisplusdemo.entity.Dept;
import com.atlzq.mybatisplusdemo.entity.User;
import com.atlzq.mybatisplusdemo.service.IDeptService;
import com.atlzq.mybatisplusdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManyDataSourceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private IDeptService deptService;

    /*多数据源测试*/
    @Test
    public void dataSourceTest(){
        List<User> list = userService.list(null);
        list.forEach(System.out::println);
        List<Dept> list1 = deptService.list(null);
        list1.forEach(System.out::println);
    }
}
