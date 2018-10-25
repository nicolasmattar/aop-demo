package com.nicolasmattar.demo.aop.validator.impl;

import com.nicolasmattar.demo.aop.validator.api.Validate;
import com.nicolasmattar.demo.aop.validator.api.Validator;
import org.springframework.core.annotation.SynthesizingMethodParameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArgumentValidation {

    private final Object arg;
    private final SynthesizingMethodParameter parameter;

    public ArgumentValidation(Object arg, SynthesizingMethodParameter parameter) {
        this.arg = arg;
        this.parameter = parameter;
    }

    public Object getArgValue() {
        return arg;
    }

    private boolean includeValidateAnnotation() {
        return parameter.getParameterAnnotation(Validate.class) != null;
    }

    public List<Class<? extends Validator>> getValidators() {
        if (!includeValidateAnnotation()) {
            return Collections.emptyList();
        }
        return Arrays.asList(parameter.getParameterAnnotation(Validate.class).value());
    }
}
