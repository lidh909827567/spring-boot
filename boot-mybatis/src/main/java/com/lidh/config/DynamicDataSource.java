package com.lidh.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by lidhk on 2018/7/31.
 *
 * @author lidhk
 */
public class  DynamicDataSource extends AbstractRoutingDataSource {

    private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为{}"+ DataSourceContextHolder.getDB());

        return DataSourceContextHolder.getDB();
    }
}
