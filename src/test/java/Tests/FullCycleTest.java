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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.ConfirmPage;
import PageObjects.LandingPage;
import PageObjects.ProductSelection;
import TestComponents.SubmitTest2;

	public class FullCycleTest extends SubmitTest2{
		

		@Test(dataProvider="getdata")
		public void submitTest(String username, String Password) throws IOException {
				
			String  itemNeeded = "Sauce Labs Backpack";
				
			ProductSelection ps = l.loginApplication(username, Password);
			ps.addItemToCart(itemNeeded);
			ps.getProductList();
			CartPage cp = ps.clickAddToCart();
			cp.getListofItemsInCart();
			CheckOutPage ck = cp.verifyProducts(itemNeeded);	
			ConfirmPage confirm = ck.enterValidInfo("Chintu", "Nani", "65746");
			confirm.getConfirmMessage();	
				
	}
		
		@DataProvider
		public Object[][] getdata() {
			
			return new Object[][] {{"standard_user", "secret_sauce"}, 
				{"locked_out_user",  "secret_sauce"}};
		}
}