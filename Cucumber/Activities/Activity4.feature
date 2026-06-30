@activity4
Feature: Login Test
	Scenario: Testing Login without examples
		Given the user is on the login page
		When the user enters "admin" and "password"
		And clicks the submit button
		Then get the confirmation text and verify the message as "Welcome Back, Admin!"