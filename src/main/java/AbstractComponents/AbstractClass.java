package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {
	
	WebDriver c;
	
	public AbstractClass(WebDriver c) {
		
		this.c = c;
		PageFactory.initElements(c, this);

	}
	
	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait w = new WebDriverWait(c, Duration.ofSeconds(3));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
			
	}
	

}
