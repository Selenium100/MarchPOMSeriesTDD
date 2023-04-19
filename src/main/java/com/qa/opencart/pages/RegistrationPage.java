package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	private By firstName = By.name("firstname");
	private By lastName = By.name("lastname");
	private By email = By.name("email");
	private By telephone = By.name("telephone");
	private By password = By.id("input-password");
	private By passwordConfirm = By.id("input-confirm");
	private By subscribeYesCheckbox = By.xpath("//label[@class='radio-inline']/input[@value='1']");
	private By subscribeNoCheckbox = By.xpath("//label[@class='radio-inline']/input[@value='0']");
	private By agreePrivacyPolicy = By.xpath("//input[@name='agree']");
	private By continueBtn = By.xpath("//input[@value='Continue']");
	private By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	public String userRegister(String firstName, String lastName, String email,String telephone, String password,
			                 String subscribe ) {
		
		boolean isFirstNameMandetory= eleUtil.isMandetoryField("input-firstname");
		System.out.println("Is FirstName Mandetory? " + isFirstNameMandetory);
		eleUtil.doSendKeysWithVisibleElement(this.firstName, AppConstants.DEFAULT_TIMEOUT, firstName);
		boolean isLastNameMandetory= eleUtil.isMandetoryField("input-lastname");
		System.out.println("Is Lastname Mandetory? " + isLastNameMandetory);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.passwordConfirm, password);
		
		if(subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYesCheckbox);
		}else if(subscribe.equalsIgnoreCase("no")) {
			eleUtil.doClick(subscribeNoCheckbox);
		}
		
		eleUtil.doClick(agreePrivacyPolicy);
		eleUtil.doClick(continueBtn);
		
		String message = eleUtil.waitForElementVisible(successMessage, AppConstants.DEFAULT_LONG_TIMEOUT).getText();
		System.out.println("Success Message is =======>> " + message);
		
		eleUtil.doClick(logoutLink);
		eleUtil.doClick(registerLink);
		
		return message;
		
		
		
	}
	
	
	

}
