package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. By Locators: private
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//div[@class='row']//a");
	private By registerLink = By.linkText("Register");
	private By loginError = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	// 2. constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	// 3. page actions:
	public String getLoginPageTitle() {
		return elementUtil.getPageTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean isForgotPwdLinkExist() {

		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public AccountsPage doLogin(String un, String pwd) {
		elementUtil.doPresenceOfElementLocated(emailId, Constants.DEFAULT_TIME_OUT).sendKeys(un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
	}

	public List<String> getFooterLinks() {
		List<WebElement> footerList = elementUtil.getElements(footerLinks);
		List<String> footerTextList = new ArrayList<String>();

		for (WebElement e : footerList) {
			footerTextList.add(e.getText());
		}
		return footerTextList;

	}
/* Navigate to registration page*/
	public RegistrationPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
}






