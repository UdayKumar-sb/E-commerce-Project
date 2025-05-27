package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
		
	public static void main(String[] args) {

			
		String  itemNeeded = "Sauce Labs Backpack";
			
		WebDriver c = new FirefoxDriver();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w = new WebDriverWait(c, Duration.ofSeconds(3));
		
		
		
		//Landing Page
		c.get("https://www.saucedemo.com/");
			
		c.findElement(By.id("user-name")).sendKeys("standard_user");
		c.findElement(By.id("password")).sendKeys("secret_sauce");
		c.findElement(By.id("login-button")).click();
	
		List<WebElement> items = c.findElements(By.cssSelector(".inventory_item"));
				
		for(WebElement item : items) {
				
			String itemName = item.findElement(By.cssSelector(".inventory_item_name")).getText();
			System.out.println("Name of the items :" +itemName);
				
			if(itemName.equalsIgnoreCase(itemNeeded)) {
				item.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();
				}
			}
			
		c.findElement(By.cssSelector(".shopping_cart_container")).click();
			
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title")));
			
		List<WebElement> cartItems = c.findElements(By.cssSelector(".cart_item"));
			
		for(WebElement itemInCart : cartItems) {
			String cartItemName = itemInCart.findElement(By.cssSelector(".inventory_item_name")).getText();
			System.out.println("Item in cart: " +cartItemName);
			if(cartItemName.equals(itemNeeded)) {
				c.findElement(By.id("checkout")).click();
				break;
			}
		}
			
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title")));
			
		c.findElement(By.id("first-name")).sendKeys("Chintu");
		c.findElement(By.id("last-name")).sendKeys("Nani");
		c.findElement(By.id("postal-code")).sendKeys("65746");
			
		c.findElement(By.id("continue")).click();
			
		String SummaryInfo = c.findElement(By.cssSelector(".summary_value_label")).getText();
		System.out.println("Summary of the order: " +SummaryInfo);
			
		String shippingInfo = c.findElement(By.cssSelector(".summary_info_label")).getText();
		System.out.println("Shiping Info: " +shippingInfo);
			
		c.findElement(By.id("finish")).click();
			
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title")));
			
		String ConfirmMessage = c.findElement(By.cssSelector(".complete-header")).getText();
		System.out.println("Confirm Message: " +ConfirmMessage);
	}	
}

