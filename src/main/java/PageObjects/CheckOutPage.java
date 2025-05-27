package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class CheckOutPage extends AbstractClass {
	
	WebDriver c;

	public CheckOutPage(WebDriver c) {
		super(c);
		this.c = c;
		PageFactory.initElements(c, this);
	}
	
	@FindBy(id="first-name")
	WebElement FirstName;
	
	@FindBy(id="last-name")
	WebElement LastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement Button;
	
	public ConfirmPage enterValidInfo(String fName, String lName, String pCode ) {
		
		FirstName.sendKeys(fName);
		LastName.sendKeys(lName);
		postalCode.sendKeys(pCode);
		Button.click();
		ConfirmPage confirm = new ConfirmPage(c);
		return confirm;
	}
}


//c.findElement(By.id("first-name")).sendKeys("Chintu");
//c.findElement(By.id("last-name")).sendKeys("Nani");
//c.findElement(By.id("postal-code")).sendKeys("65746");
//	
//c.findElement(By.id("continue")).click();