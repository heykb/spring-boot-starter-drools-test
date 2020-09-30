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
 * The type Release id drools test.
 *
 * @author heykb
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReleaseIdDroolsTest {
    @KServices
    private KieServices kieServices;

    @KContainer
    @KReleaseId(groupId = "com.zhu",artifactId = "drools-kjar-maven",version = "LATEST")
    private KieContainer kieContainer;

    @KBase("kbase")
    @KReleaseId(groupId = "com.zhu",artifactId = "drools-kjar-maven",version = "LATEST")
    private KieBase kieBase;

    @KSession("hello")
    @KReleaseId(groupId = "com.zhu",artifactId = "drools-kjar-maven",version = "LATEST")
    private KieSession kieSession;


    /**
     * Test.
     */
    @Test
    public void test(){

        HelloFact helloFact = new HelloFact();
        // new default Kie session
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(helloFact);
        int num = kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println(String.format("触发了%d条规则",num));
        System.out.println(helloFact.getMessage());
        assert("hello!! i am from remote rep kie".equals(helloFact.getMessage()));
    }

}
