package com.lidh.zookeeper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lidhk on 2018/8/29.
 *
 * @author lidhk
 */
public class OrderNumberConfig {
    private static int count = 0;

    public String getNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + "-" + ++count;
    }
}
