package com.dra.mqtt.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * mapper生成器
 * </p>
 *
 * @author: dra
 * @since: 2022/5/22
 */
public class MapperGenerator {
    private static final String URL = "jdbc:mysql://localhost:3306/mqtt?charset=utf-8&useUnicode=true&useSSL=true&autoReconnect=true&failOverReadOnly=false&serverTimezone=Asia/Shanghai";
    private static final String USERNAME = "root";
    private static final String PWD = "123456";
    private static final String WORK_DIR = "C:\\Users\\DRAGON\\Documents\\workspace\\workspace-java\\SpringCloudTest\\mqtt-test\\src\\main\\";
    private static final String PACKAGE = "com.dra.mqtt";
    //    private static final String PACKAGE_DIR = "java\\com\\dra";
    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PWD)
                .globalConfig(builder -> {
                    builder.author("dra") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(WORK_DIR+"\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(PACKAGE) // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,WORK_DIR+"\\resources\\mappers"));
                })
                .strategyConfig(builder -> {
                    List<String> list = new ArrayList<>();
                    list.add("mq_user_sub");
                    builder .addInclude(list);
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
