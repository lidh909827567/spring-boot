package com.lidh.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by lidhk on 2018/11/21.
 *
 * @author lidhk
 */
public class AnnotationTest {
    public static void main(String[] args) {
        try {
            //使用类加载器
            Class cla = Class.forName("com.lidh.annotation.AnnotationDemo");
            //找到类上面得注解
            boolean isExit = cla.isAnnotationPresent(Custom.class);
            if (isExit){
                Custom annotation = (Custom)cla.getAnnotation(Custom.class);
                System.out.println(annotation.age()+annotation.name());
            }
            Method[] methods = cla.getMethods();
            for (Method method:methods) {
                boolean flag = method.isAnnotationPresent(Custom.class);
                if (flag){
                    Custom custom = (Custom)method.getAnnotation(Custom.class);
                    System.out.println(custom.age()+custom.name());
                }
            }
            for (Method method:methods) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation:annotations) {
                    if (annotation instanceof Custom){
                        Custom c = (Custom)annotation;
                        System.out.println(c.age()+c.name());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
