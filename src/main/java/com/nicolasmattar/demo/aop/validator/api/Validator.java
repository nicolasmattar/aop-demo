package com.nicolasmattar.demo.aop.validator.api;

public interface Validator<T> {

    void validate(T target);

}
