package com.nicolasmattar.demo.aop;

import com.nicolasmattar.demo.aop.core.model.DemoObject;
import com.nicolasmattar.demo.aop.core.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopDemoApplicationTests {

    @Autowired
    private DemoService demoService;

    @Test
    public void test() {
        System.out.println("=========================START===========================");

        DemoObject testObject = new DemoObject(1L, "Test Object");
        demoService.execute0(testObject);
        System.out.println("=========================================================");

        demoService.execute1(testObject);
        System.out.println("=========================================================");

        demoService.execute1(testObject, testObject);
        System.out.println("=========================================================");

        demoService.execute2(testObject, testObject);
        System.out.println("=========================================================");

        demoService.execute3(testObject, testObject);
        System.out.println("=========================================================");

        demoService.execute4(testObject);
        System.out.println("=========================================================");
    }
}