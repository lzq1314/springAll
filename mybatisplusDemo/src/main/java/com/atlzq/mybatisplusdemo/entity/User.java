package com.atlzq.mybatisplusdemo.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
/*当表名与实体类不一致时使用此注解进行映射，如果表名与实体类名称一致则此注解可以省略*/
@TableName("user")
public class User {

    /*mybatis-plus 默认将id作为主键，雪花算法生成id的值；
    @TableId 指定字段为主键，如果实体类主键名称就是id则此注解可以省略；
    @TableId(value="uid") 当主键的表字段名称为uid，实体字段为id时，使用value字段进行映射；
    @TableId(type=IdType.AUTO) type属性是控制主键生成规则，默认是雪花算法，IdType.AUTO 是递增*/
    @TableId()
    private Long id;

    /*@TableField(value="name") 当字段名与数据库列名不一致时，需要映射，例如当数据库字段名有下划线，而我们做的实体字段使用驼峰命名的时候就需要指定映射关系*/
    private String name;

    private Integer age;

    private String email;

    /*@TableLogic 逻辑删除，修改当前字段值为1*/
    private Integer isDeleted;

}
