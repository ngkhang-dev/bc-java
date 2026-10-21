package com.cybersoft.demospringboot.config;

import com.cybersoft.demospringboot.dto.DatabaseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// SP khởi động, quét qua từng tầng.
// Khi tới tầng config, sẽ quét các class có @Configuration và các hàm/method trong class có annotation @Bean
@Configuration
public class SqlConfig {

    @Value("${database.oracle.url}") // Lấy giá trị của các custom key đã khai báo trong file application.properties
    String oracleUrlFromPropertiesFile;

    @Bean("db1") // Mặc định, SP sẽ sử dụng tên hàm làm tên cho bean
    public DatabaseDTO connectOracle() {
        DatabaseDTO databaseDTO = new DatabaseDTO();

//        databaseDTO.setUrl("oracle url");
        databaseDTO.setUrl(oracleUrlFromPropertiesFile);
        databaseDTO.setUsername("oracle username");
        databaseDTO.setPassword("");

        System.out.println("Connect oracle");
        return databaseDTO;
    }

    @Bean("db2")
    @Primary // Khi có nhiều bean cùng kiểu dữ liệu trả về, sẽ ưu tiên/mặc định sử dụng
    public DatabaseDTO connectSQL() {
        DatabaseDTO databaseDTO = new DatabaseDTO();
        databaseDTO.setUrl("sql url");
        databaseDTO.setUsername("sql username");
        databaseDTO.setPassword("");

        System.out.println("Connect sql");
        return databaseDTO;
    }
}
