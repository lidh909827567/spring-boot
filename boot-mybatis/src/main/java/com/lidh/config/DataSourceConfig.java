package com.lidh.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lidhk on 2018/7/31.
 *
 * @author lidhk
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource1.url}")
    private String url1;

    @Value("${spring.datasource1.username}")
    private String username1;

    @Value("${spring.datasource1.password}")
    private String password1;


    @Value("${spring.datasource2.url}")
    private String url2;

    @Value("${spring.datasource2.username}")
    private String username2;

    @Value("${spring.datasource2.password}")
    private String password2;

//    @Bean(name = "db1")
//    @ConfigurationProperties(prefix = "spring.datasource.datasource1")
    public DataSource dataSource1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url1);
        dataSource.setUsername(username1);
        dataSource.setPassword(password1);
        return dataSource;
    }

//    @Bean(name = "db2")
//    @ConfigurationProperties(prefix = "spring.datasource.datasource2")
    public DataSource dataSource2(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url2);
        dataSource.setUsername(username2);
        dataSource.setPassword(password2);
        return dataSource;
    }
    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Primary
    @Bean
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(2);
        dsMap.put("db1", dataSource1());
        dsMap.put("db2", dataSource2());

        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }
}
