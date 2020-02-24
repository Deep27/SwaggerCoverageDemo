package io.deep27soft.api_test_coverage;

import io.deep27soft.api_test_coverage.model.Greeting;
import org.testng.annotations.Test;

import static io.deep27soft.api_test_coverage.Utils.get;
import static org.testng.Assert.assertTrue;

public class SpringBootTest {

    @Test
    public void testGreeting() {
        Greeting greeting = get("/greeting").extract().jsonPath().getObject("", Greeting.class);
        assertTrue(greeting.getId() > 0);
        assertTrue(greeting.getContent().startsWith("Hello, "));
    }
}
