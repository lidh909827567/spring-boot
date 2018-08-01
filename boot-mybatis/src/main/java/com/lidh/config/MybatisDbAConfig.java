//package com.lidh.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//
///**
// * Created by lidhk on 2018/7/31.
// *
// * @author lidhk
// */
//@Configuration
////@MapperScan(basePackages = {"com.lidh.mapper"},sqlSessionFactoryRef = "sqlSessionFactory1")
//public class MybatisDbAConfig {
//
//    @Autowired
////    @Qualifier("db1")
//    private DataSource dataSource;
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory1() throws Exception{
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));
//        return factoryBean.getObject();
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.lidh.mapper");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory1");
//        return mapperScannerConfigurer;
//    }
//
////    @Bean
////    public SqlSessionTemplate sqlSessionTemplate1() throws Exception{
////        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1());
////        return template;
////    }
//}
