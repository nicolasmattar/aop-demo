package com.nicolasmattar.demo.aop.core.service;

import com.nicolasmattar.demo.aop.core.model.DemoObject;
import com.nicolasmattar.demo.aop.core.validator.DemoObjectValidator;
import com.nicolasmattar.demo.aop.core.validator.DemoObjectValidator2;
import com.nicolasmattar.demo.aop.core.validator.DemoObjectValidatorError;
import com.nicolasmattar.demo.aop.validator.api.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void execute0(DemoObject param1) {
        logger.info("Executing... 0");
    }

    public void execute1(@Validate(DemoObjectValidator.class) DemoObject param1) {
        logger.info("Executing... 1");
    }

    public void execute1(@Validate(DemoObjectValidator.class) DemoObject param1, DemoObject param2) {
        logger.info("Executing... 2");
    }

    public void execute2(DemoObject param1, @Validate(DemoObjectValidator.class) DemoObject param2) {
        logger.info("Executing... 3");
    }

    public void execute3(@Validate({DemoObjectValidator.class, DemoObjectValidator2.class}) DemoObject param1, @Validate(DemoObjectValidator.class) DemoObject param2) {
        logger.info("Executing... 4");
    }

    public void execute4(@Validate(DemoObjectValidatorError.class) DemoObject param1) {
        logger.info("Executing... 5");
    }
}
