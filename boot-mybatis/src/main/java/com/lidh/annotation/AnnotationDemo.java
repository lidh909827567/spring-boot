package com.lidh.annotation;

/**
 * Created by lidhk on 2018/11/21.
 *
 * @author lidhk
 */
@Custom(name="我是类注解",age = 10)
public class AnnotationDemo {

    @Custom(name="我是方法注解",age = 5)
    public void get(){
        System.out.println("name");
        System.out.println("age");
    }
}
