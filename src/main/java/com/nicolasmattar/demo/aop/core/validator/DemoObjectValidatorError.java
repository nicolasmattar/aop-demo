package com.nicolasmattar.demo.aop.core.validator;

import com.nicolasmattar.demo.aop.core.model.DemoObject;
import com.nicolasmattar.demo.aop.validator.api.ValidationException;
import com.nicolasmattar.demo.aop.validator.api.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoObjectValidatorError implements Validator<DemoObject> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void validate(DemoObject target) {
        logger.info("Validating with Error..." + target);
        throw new ValidationException();
    }
}
