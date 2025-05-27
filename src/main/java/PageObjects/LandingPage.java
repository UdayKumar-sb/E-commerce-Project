package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class LandingPage extends AbstractClass {
	
	WebDriver c;
	
	public LandingPage(WebDriver c) {
		super(c);
		this.c =c;
		PageFactory.initElements(c, this);
	}
	
		@FindBy(id="user-name")
		WebElement userName;
		
		@FindBy(id="password")
		WebElement passWord;
		
		@FindBy(id="login-button")
		WebElement login;
		
		@FindBy(xpath="//h3[@data-test='error']")
		WebElement errorMessage;
		
		
		
		public ProductSelection loginApplication(String username, String Password) {
			
			userName.sendKeys(username);
			passWord.sendKeys(Password);
			login.click();
			ProductSelection ps = new ProductSelection(c);
			return ps;
		}	
		
		
		public void goTo() {
			c.get("https://www.saucedemo.com/");
		}
		
		public String getErrorMessage() {
			
			String ErrorMessage = errorMessage.getText();
			return ErrorMessage;
		}
}




//Landing Page
//c.get("https://www.saucedemo.com/");		
//c.findElement(By.id("user-name")).sendKeys("standard_user");
//c.findElement(By.id("password")).sendKeys("secret_sauce");
//c.findElement(By.id("login-button")).click();