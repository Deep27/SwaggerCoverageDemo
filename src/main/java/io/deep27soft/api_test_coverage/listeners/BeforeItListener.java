package io.deep27soft.api_test_coverage.listeners;

import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.restassured.RestAssured;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class BeforeItListener implements ISuiteListener {


    @Override
    public void onStart(ISuite iSuite) {
        RestAssured.filters(new SwaggerCoverageRestAssured());
    }

    @Override
    public void onFinish(ISuite iSuite) {

    }
}
