package com.lz.express;

import com.lz.express.config.datasources.DynamicDataSourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.lz.express.*",exclude ={ DataSourceAutoConfiguration.class})
@Slf4j
@MapperScan("com.lz.express.mapper")
@EnableFeignClients(basePackages = "com.lz.express.*")
@Import({DynamicDataSourceConfig.class})
public class ExpressApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpressApplication.class, args);
    }

}
