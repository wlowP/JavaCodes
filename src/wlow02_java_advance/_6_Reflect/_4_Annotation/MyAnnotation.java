package wlow02_java_advance._6_Reflect._4_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
// 自定义注解
public @interface MyAnnotation {
    String message() default "msg";
    int number();
}
