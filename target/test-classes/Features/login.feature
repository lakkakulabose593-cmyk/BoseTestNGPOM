Feature: feature to test login functionality  

	Scenario: Checklogin is successfull or not

		Given user is on login page
		When user enters user name and password
		And click on login button
		Then user is navigated to the home page

