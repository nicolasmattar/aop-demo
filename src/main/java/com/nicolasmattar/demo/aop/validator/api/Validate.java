package com.nicolasmattar.demo.aop.validator.api;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface Validate {
    Class<? extends Validator>[] value();
}
