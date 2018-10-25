package com.nicolasmattar.demo.aop.validator.impl;

import com.nicolasmattar.demo.aop.validator.api.Validator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.SynthesizingMethodParameter;

import java.lang.reflect.Method;
import java.util.stream.IntStream;


@Aspect
@Configuration
public class ValidatorAspect {

    private ApplicationContext applicationContext;
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorAspect.class);

    public ValidatorAspect(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Before("execution(public * *(.., @com.nicolasmattar.demo.aop.validator.api.Validate (*), ..))")
    public void before(JoinPoint joinPoint) {
        LOGGER.info("Validating...");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();

        IntStream.range(0, args.length)
                .mapToObj(i -> new ArgumentValidation(args[i], new SynthesizingMethodParameter(method, i)))
                .forEach(this::validate);
    }

    private void validate(ArgumentValidation argumentValidation) {
        argumentValidation.getValidators().stream()
                .map(applicationContext::getBean)
                .forEach(v -> ((Validator) v).validate(argumentValidation.getArgValue()));
    }
}