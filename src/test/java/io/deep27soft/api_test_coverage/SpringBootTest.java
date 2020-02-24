package io.deep27soft.api_test_coverage;

import io.deep27soft.api_test_coverage.model.Greeting;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.deep27soft.api_test_coverage.Utils.get;
import static org.testng.Assert.*;

public class SpringBootTest {

    @BeforeClass
    public void initGreetings() {
        get("/greeting");
        get("/greeting?name=Vasiliy");
    }

    @Test
    public void testGreeting() {
        ValidatableResponse response = get("/greeting");
        Greeting greeting = response.extract().jsonPath().getObject("", Greeting.class);
        assertTrue(greeting.getId() > 0);
        assertTrue(greeting.getContent().startsWith("Hello, "));
    }

    @Test
    public void testGreetingWithName() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Vasiliy");
        ValidatableResponse response = get("/greeting", params);
        Greeting greeting = response.extract().jsonPath().getObject("", Greeting.class);
        assertTrue(greeting.getId() > 0);
        assertEquals(greeting.getContent(), "Hello, Vasiliy!");
    }

    @Test
    public void testGreetingById() {
        Map<String, Long> params = new HashMap<>();
        params.put("id", 1L);
        ValidatableResponse response = get("/greetingById", params);
        Greeting greeting = response.extract().jsonPath().getObject("", Greeting.class);
        assertEquals(greeting.getId(), 1);
        assertEquals(greeting.getContent(), "Hello, World!");
    }
}
