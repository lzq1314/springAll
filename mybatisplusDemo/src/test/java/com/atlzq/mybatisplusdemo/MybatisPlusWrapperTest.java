package com.atlzq.mybatisplusdemo;

import com.atlzq.mybatisplusdemo.entity.User;
import com.atlzq.mybatisplusdemo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectList() {
        //查询用户名包含a,年龄在20-30之间，邮箱信息不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.like("name", "a").between("age", 20, 30).isNotNull("email");
        List<User> list = userService.list(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void selectListOrder() {
        //查询用户名包含a,年龄在20-30之间，邮箱信息不为null的用户信息,年龄降序，若年龄一样按照id升序
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email")
                .orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userService.list(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void deleteWrapper(){
        //删除email为空的数据
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        boolean remove = userService.remove(queryWrapper);
        System.out.println(remove);
    }

    @Test
    public void updateWrapper(){
        //修改用户名包含a,年龄在20-30之间，或邮箱信息不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .between("age", 20, 30)
                .or().isNull("email");
        User user = new User();
        user.setName("lzq修改");
        boolean update = userService.update(user, queryWrapper);
        System.out.println(update);
    }

    //条件优先级
    @Test
    public void conditionFirstOrSecond(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .and(i-> i.between("age", 20, 30).or().isNull("emaol"));
        User user = new User();
        user.setName("lzq修改");
        boolean update = userService.update(user, queryWrapper);
        System.out.println(update);
    }

    //查询子句
    @Test
    public void selectChildrenCondition(){
        //指定查询字段查询用户名、年龄
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age");
        List<Map<String, Object>> maps = userService.listMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    //子查询
    @Test
    public void selectChildrenCondition1(){
        //先查询出来id小于100然后再查询age大于23的
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from user where id <=100").gt("age",20);
        List<Map<String, Object>> maps = userService.listMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void updateWrapperTest(){
        //修改用户名包含a,年龄在20-30之间，或邮箱信息不为null的用户信息
        UpdateWrapper<User> updateWrapper = new UpdateWrapper();
        updateWrapper.like("name", "a")
                .between("age", 20, 30)
                .or().isNull("email");
        updateWrapper.set("name","lzq第二次i需改");
        boolean update = userService.update(updateWrapper);
        System.out.println(update);
    }

    @Test
    public void selectByTrendsConditions(){
        //动态组装条件
        String name = "";
        Integer ageStart = 10;
        Integer ageEnd = 20;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name),"name",name).between(ageStart != null && ageEnd != null,"age",ageStart,ageEnd);
        List<User> list = userService.list(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void lambQueryWrapperTest(){
        String name = "";
        Integer ageStart = 10;
        Integer ageEnd = 20;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name),User::getName,name).between(ageStart != null && ageEnd != null,User::getAge,ageStart,ageEnd);
        List<User> list = userService.list(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void lambdaUpdateWrapperTest(){
        //修改用户名包含a,年龄在20-30之间，或邮箱信息不为null的用户信息
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper();
        updateWrapper.like(User::getName,"a").between(User::getAge,10,20).set(User::getName,"lzq第三次修改");
        boolean update = userService.update(updateWrapper);
        System.out.println(update);
    }
}
