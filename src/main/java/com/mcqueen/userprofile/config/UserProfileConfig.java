package com.mcqueen.userprofile.config;

import com.mcqueen.userprofile.UserProfileApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Import({SwaggerConfig.class, WebConfig.class})
//@SpringBootApplication(scanBasePackageClasses = {UserProfileApplication.class})
//@MapperScan(basePackageClasses = {UserProfileApplication.class})
//@EnableAspectJAutoProxy
//@EnableSwagger2

public class UserProfileConfig {
}
