package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class CartPage extends AbstractClass{
	
	WebDriver c;

	public CartPage(WebDriver c) {
		super(c);
		this.c =c;
		PageFactory.initElements(c, this);
		
	}
	
	@FindBy(css=".cart_item")
	List<WebElement> cartItems;
	
	By CartItemName = By.cssSelector(".inventory_item_name");
	
	@FindBy(id="checkout")
	WebElement ChkBtn;
	
	By Title = By.cssSelector(".title");
	
	
	public List<WebElement> getListofItemsInCart() {
		
		List<WebElement> cartItems = c.findElements(By.cssSelector(".cart_item"));
		return cartItems;
		
	}
	
	public CheckOutPage verifyProducts(String itemNeeded) {
		
		for(WebElement itemInCart : cartItems) {
			String cartItemName = itemInCart.findElement(By.cssSelector(".inventory_item_name")).getText();
			System.out.println("Item in cart: " +cartItemName);
			if(cartItemName.equals(itemNeeded)) {
				c.findElement(By.id("checkout")).click();
				break;
				
		
	}
		}
		
		waitForElementToAppear(Title);
		CheckOutPage ck = new CheckOutPage(c);
		return ck;

} 
	}


//List<WebElement> cartItems = c.findElements(By.cssSelector(".cart_item"));
//
//for(WebElement itemInCart : cartItems) {
//	String cartItemName = itemInCart.findElement(By.cssSelector(".inventory_item_name")).getText();
//	System.out.println("Item in cart: " +cartItemName);
//	if(cartItemName.equals(itemNeeded)) {
//		c.findElement(By.id("checkout")).click();
//		break;
//	}
//}