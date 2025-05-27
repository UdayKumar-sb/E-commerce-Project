package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class ConfirmPage extends AbstractClass{
	
	WebDriver c;

	public ConfirmPage(WebDriver c) {
		super(c);
		this.c=c;
		PageFactory.initElements(c, this);
	}
	
	@FindBy(css=".summary_value_label")
	WebElement summaryInfo;
	
	@FindBy(css=".summary_info_label")
	WebElement shippingInfo;
	
	@FindBy(id="finish")
	WebElement Button;
	
	By Title = By.cssSelector(".title");
	
	@FindBy(css=".complete-header")
	WebElement confirmMessage;
	
	public void getConfirmMessage() {
		
		String SummaryInfo = summaryInfo.getText();
		System.out.println("Summary of the order: " +SummaryInfo);
		
		String shippinginfo = shippingInfo.getText();
		System.out.println("Shiping Info: " +shippingInfo);
		
		Button.click();
		
		waitForElementToAppear(Title);
		
		String ConfirmMessage = confirmMessage.getText();
		System.out.println("Confirm Message: " +ConfirmMessage);

	}
}


//String SummaryInfo = c.findElement(By.cssSelector(".summary_value_label")).getText();
//System.out.println("Summary of the order: " +SummaryInfo);
//	
//String shippingInfo = c.findElement(By.cssSelector(".summary_info_label")).getText();
//System.out.println("Shiping Info: " +shippingInfo);
//	
//c.findElement(By.id("finish")).click();
//	
//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title")));
//	
//String ConfirmMessage = c.findElement(By.cssSelector(".complete-header")).getText();
//System.out.println("Confirm Message: " +ConfirmMessage);