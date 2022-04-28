/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Appium Mobile Automation - Android & iOS + Frameworks + CICD (https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package com.appium.runners;

import io.cucumber.testng.CucumberOptions;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(
		plugin = { "pretty", "html:target_TestNG/iPhone_13/cucumber-report.html", "summary"
		// "de.monochromata.cucumber.report.PrettyReports:target/Pixel_3/cucumber-html-reports"}
		, "me.jvt.cucumber.report.PrettyReports:target_TestNG/iPhone_13/" }, features = {
				"src/test/resources/features" }, glue = {
						"com.appium.stepDefinitions" }, dryRun = false, monochrome = true
// ,strict=true
		, tags = "@login-feature")
public class TestNGRunner_iPhone13 extends RunnerBase {
}