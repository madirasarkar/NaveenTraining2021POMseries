package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;

public class RegistrationPageTest extends BaseTest {
	@BeforeClass
	public void setUpRegistration() {
	registrationPage = loginPage.navigateToRegisterPage();
	}
	
	public void userRegistrationTest() {
		
	}
}
