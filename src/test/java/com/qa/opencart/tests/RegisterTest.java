package com.qa.opencart.tests;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtils;

public class RegisterTest extends BaseTest {
	
	@BeforeClass
	public void registrationSetup() {
		register = login.navigaeToRegisterPage();
	}
	
	@DataProvider(name ="getdata")
	public Object[][] getData(){
		 return ExcelUtils.getTestData(System.getProperty("user.dir")+"/src/test/resources/testdata/RegisterTest.xlsx", "data");
		
	}
	
	public String randomEmail() {
		Random rand = new Random();
		String randString = RandomStringUtils.randomAlphabetic(10);
		String email =randString+rand.nextInt(100000)+"@gmail.com";
		return email;
	}
	
	@Test(dataProvider = "getdata")
	public void registerUserTest(String firstName,String lastName, String email, String telehone,String password, String subscribe) {
		String successMessage =  register.userRegister(firstName, lastName, randomEmail(), telehone, password, subscribe);
		Assert.assertEquals(successMessage, AppConstants.ACC_CREATE_SUCCESS_MSG);
	}
	
	

}
