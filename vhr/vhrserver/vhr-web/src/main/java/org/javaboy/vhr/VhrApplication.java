package org.javaboy.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "org.javaboy.vhr.mapper")
//@EnableScheduling     //只对Web依赖模块的@Scheduled注解管用
@EnableBatchProcessing  //开启Spring Bache
public class VhrApplication {

    public static void main(String[] args) {
//        SpringApplication.run(VhrApplication.class, args);
        SpringApplicationBuilder builder=new SpringApplicationBuilder(VhrApplication.class);
        builder.bannerMode(Banner.Mode.CONSOLE).run(args);
    }

}


















