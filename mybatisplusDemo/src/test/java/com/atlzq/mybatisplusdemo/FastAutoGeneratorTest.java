package com.atlzq.mybatisplusdemo;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        /*String url = "jdbc:mysql://localhost:3306/mybatis_plus?characterEncoding=utf-8&userSSL=false";
        String username = "root";
        String password = "root";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("lzq") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir("C:\\lizhiqiang\\D\\javaProject\\narriProject\\tmpMybatisplus"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.atlzq") // 设置父包名
                            .moduleName("mybatisplusdemo") // 设置父包模块名
                            .entity("entity") //设置entity包名
                            .other("model.dto") // 设置dto包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C:\\lizhiqiang\\D\\javaProject\\narriProject\\tmpMybatisplus")); // 设置mapperXml生成路径

                }).strategyConfig(builder ->{
                    builder.addInclude("user").addTablePrefix("t_","c_");
        }).templateEngine( new FreemarkerTemplateEngine()).execute();*/

        String url = "jdbc:mysql://localhost:3306/vhr?characterEncoding=utf-8&userSSL=false";
        String username = "root";
        String password = "root";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("lzq") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir("C:\\lizhiqiang\\D\\javaProject\\narriProject\\tmpMybatisplus"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.atlzq") // 设置父包名
                            .moduleName("mybatisplusdemo") // 设置父包模块名
                            .entity("entity") //设置entity包名
                            .other("model.dto") // 设置dto包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C:\\lizhiqiang\\D\\javaProject\\narriProject\\tmpMybatisplus")); // 设置mapperXml生成路径

                }).strategyConfig(builder ->{
            builder.addInclude("dept").addTablePrefix("t_","c_");
        }).templateEngine( new FreemarkerTemplateEngine()).execute();


    }

}
