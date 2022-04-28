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
Feature: Product scenarios

  Scenario Outline: Validate product info on Products page
    Given I'm logged in
    Then the product is listed with title "<title>" and price "<price>"

    Examples: 
      | title                   | price  |
      | Sauce Labs Bolt T-Shirt | $15.99 |
  #      | Sauce Labs Onesie       | $7.99  |
  #      | Test.allTheThings() T-Shirt (Red) | $15.99 |
  #      | Sauce Labs Backpack     | $29.99 |
  Scenario Outline: Validate product info on Product Details page
    Given I'm logged in
    When I click product title "<title>"
    Then I should be on product details page with title "<title>", price "<price>" and description "<description>"

    Examples: 
      | title               | price  | description                                                                                                                            |
      | Sauce Labs Backpack | $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |
 #     | Sauce Labs Bolt T-Shirt | $15.99 | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt. |