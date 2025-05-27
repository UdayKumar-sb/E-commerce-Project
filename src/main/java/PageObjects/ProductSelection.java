package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class ProductSelection extends AbstractClass{
	
	WebDriver c;
	
	public ProductSelection(WebDriver c) {
		super(c);
		this.c = c;
		PageFactory.initElements(c, this);
	}
	
	
	@FindBy(css=".inventory_item")
	List<WebElement> items;
	
	@FindBy(css=".shopping_cart_container")
	WebElement addToCart;
	
	
	By itemsby = By.cssSelector(".inventory_item_name");
	By Button = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
	By Title = By.cssSelector(".title");
	
	public List<WebElement> getProductList() {
		
		return items;
	}

	public void addItemToCart(String itemNeeded) {
		
		for(WebElement item : items) {
		String itemName = item.findElement(itemsby).getText();
		System.out.println("Name of the items :" +itemName);
		
		if(itemName.equalsIgnoreCase(itemNeeded)) {
			item.findElement(Button).click();
			}
		}

	}
	
	public CartPage clickAddToCart() {
		
		addToCart.click();
		waitForElementToAppear(Title);
		CartPage cp = new CartPage(c);
		return cp;
	}
}






//List<WebElement> items = c.findElements(By.cssSelector(".inventory_item"));
//
//for(WebElement item : items) {
//		
//	String itemName = item.findElement(By.cssSelector(".inventory_item_name")).getText();
//	System.out.println("Name of the items :" +itemName);
//		
//	if(itemName.equalsIgnoreCase(itemNeeded)) {
//		item.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();
//		}
//	}