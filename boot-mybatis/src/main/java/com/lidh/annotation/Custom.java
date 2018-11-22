package com.lidh.annotation;

import java.lang.annotation.*;

/**
 * Created by lidhk on 2018/11/21.
 *
 * @author lidhk
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Custom {
    String name() default "";

    int age();
}
