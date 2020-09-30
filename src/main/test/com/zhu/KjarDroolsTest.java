package com.zhu;


import com.zhu.drools.annotation.*;
import com.zhu.facts.HelloFact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The type Classpath drools test.
 *
 * @author heykb
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KjarDroolsTest {

    @KServices
    private KieServices kieServices;

    @KContainer
    @KJarPath("D:/下载/drools-maven-jar-1.0.0.jar")
    private KieContainer kieContainer;

    @KBase
    @KJarPath("D:\\下载\\drools-maven-jar-1.0.0.jar")
    private KieBase kieBase;

    /*@KSession
    @KJarPath("D:\\下载\\drools-maven-jar-1.0.0.jar")
    private KieSession kieSession;*/


    /**
     * Test.
     */
    @Test
    public void test(){


        HelloFact helloFact = new HelloFact();
        // new default Kie session
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(helloFact);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println(helloFact.getMessage());
        assert("hello!! i am from workbench kie".equals(helloFact.getMessage()));

    }

}
