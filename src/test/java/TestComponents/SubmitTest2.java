package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import PageObjects.LandingPage;

public class SubmitTest2 {
	
	public WebDriver c;
	public LandingPage l;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties p = new Properties();
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
		p.load(f);
		
		String browserName = p.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			c = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			c= new FirefoxDriver();
		}
		
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w = new WebDriverWait(c, Duration.ofSeconds(3));
		return c;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchAppliaction() throws IOException {
		
		c = initializeDriver();
		l = new LandingPage(c);
		l.goTo();
		return l;
	}
}
