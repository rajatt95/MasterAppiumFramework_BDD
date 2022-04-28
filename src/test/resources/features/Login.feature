#/**
#* @author Rajat Verma
#* https://www.linkedin.com/in/rajat-v-3b0685128/
#* https://github.com/rajatt95
#* https://rajatt95.github.io/
#*
#* Course: Appium Mobile Automation - Android & iOS + Frameworks + CICD (https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/)
#* Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
#*/
#
#/***************************************************/
#
@login-feature
Feature: Login scenarios
#@test

 Scenario Outline: Login with invalid user name
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then login should fail with an error "<err>"

    Examples: 
      | username        | password     | err                                                          |
      | invalidUsername | secret_sauce | Username and password do not match any user in this service. |

  Scenario Outline: Login with invalid password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then login should fail with an error "<err>"

    Examples: 
      | username      | password        | err                                                          |
      | standard_user | invalidPassword | Username and password do not match any user in this service. |

  Scenario Outline: Login with valid user name and password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then I should see Products page with title "<title>"

    Examples: 
      | username      | password     | title    |
      | standard_user | secret_sauce | PRODUCTS |
