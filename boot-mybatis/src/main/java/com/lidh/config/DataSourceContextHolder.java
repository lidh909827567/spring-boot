package com.lidh.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lidhk on 2018/7/31.
 *
 * @author lidhk
 */
public class DataSourceContextHolder {

    public static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);

    public static final String DEFAULT_DS = "db1";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源名
     */
    public static void setDB(String dbType) {
        log.debug("切换到{}数据源", dbType);
        System.out.println(dbType);
        contextHolder.set(dbType);
    }

    /**
     * 获取数据源名
     */
    public static String getDB() {
        return (contextHolder.get());
    }

    /**
     * 清除数据源名
     */
    public static void clearDB() {
        contextHolder.remove();
    }
}
