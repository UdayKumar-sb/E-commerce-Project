package Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.ConfirmPage;
import PageObjects.LandingPage;
import PageObjects.ProductSelection;
import TestComponents.SubmitTest2;

	public class LoginPageErrorValidations extends SubmitTest2{
		

		@Test(groups = "Error")
		public void LoginErrorValidations() throws IOException {
				
			String  itemNeeded = "Sauce Labs Backpack";
			ProductSelection ps = l.loginApplication("standard_user", "secret_sauc");
			System.out.println(l.getErrorMessage());
			Assert.assertEquals("incorrect email or password", l.getErrorMessage());	
	}
		
		@Test(groups = "Error")
		public void ProductErrorValidations() {
		String  itemNeeded = "Sauce Labs Backpack";
		
		ProductSelection ps = l.loginApplication("standard_user", "secret_sauce");
		ps.addItemToCart(itemNeeded);
		ps.getProductList();
		CartPage cp = ps.clickAddToCart();
		cp.getListofItemsInCart();
		CheckOutPage ck = cp.verifyProducts("Sauce Labs");	
		
	}
}
	
