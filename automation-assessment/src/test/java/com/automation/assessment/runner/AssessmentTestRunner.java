package com.automation.assessment.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\application-features", glue = { "com.automation.assessment.hooks",
		"com.automation.assessment.stepdef" }, tags = "@Assessment-UI")
public class AssessmentTestRunner extends AbstractTestNGCucumberTests {

}
