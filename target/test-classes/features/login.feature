Feature: Vision new app login tests

Scenario: Login should be success

Given User open the VisionApp
Given User click on Menu
Given User clcik on login button
Given User enter the username as jeyasankar@visionias.in
Given User enter the password as 123456
When User click on the login button
Then Login should be success


Scenario: Login should not be success

Given User open the VisionApp
Given User click on Menu
Given User clcik on login button
Given User enter the username as jeyasankar@visionias.in
Given User enter the password as 123454
When User click on the login button
But Login should be fail
