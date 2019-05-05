package com.zhuhao.annotationdemo;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
@Inherited
public @interface Test01 {

    String value() default "nijie";
}
