package com.appium.runners;

import io.cucumber.testng.CucumberOptions;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(plugin = { "pretty", "html:target_TestNG/iPhone_XR/cucumber-report.html", "summary"
		// "de.monochromata.cucumber.report.PrettyReports:target/Pixel_3/cucumber-html-reports"}
		, "me.jvt.cucumber.report.PrettyReports:target_TestNG/iPhone_XR/" }, features = {
				"src/test/resources/features" }, glue = {
						"com.appium.stepDefinitions" }, dryRun = false, monochrome = true
// ,strict=true
		, tags = "@login-feature")
public class TestNGRunner_iPhoneXR extends RunnerBase {
}