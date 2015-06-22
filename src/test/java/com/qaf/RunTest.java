package com.qaf;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
		plugin = {"pretty", "html:target/cucumber-reports/html", "json:target/cucumber.json"},
		glue = "com.qaf.stepdefinitions",
		tags = {}
		)
public class RunTest {

}
