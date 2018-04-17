package com.dxr.mgr.common.saas.annotation;

import java.lang.annotation.*;

/**
 * Created by DXR on 2018/4/12 0012 .
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserExcel {
    boolean flag() default true;
    String name();
}
