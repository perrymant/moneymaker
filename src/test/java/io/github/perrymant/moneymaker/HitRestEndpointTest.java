package io.github.perrymant.moneymaker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HitRestEndpointTest {

    @Autowired
    private ReportController reportController;

    @Test
    public void testEndpoint() {
        assertNotNull(reportController);
    }

}
