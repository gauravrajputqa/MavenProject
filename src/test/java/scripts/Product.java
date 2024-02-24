package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class Product 
{
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		  driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		  	
	}
	
  @Test(priority=1)
  public void a() throws InterruptedException, DocumentException 
  {	  
	  driver.get("https://www.saucedemo.com/");	 
	  File file = new File("object.xml");
	  SAXReader saxReader = new SAXReader();
	  Document doc = saxReader.read(file);	
	  findById(doc.selectSingleNode("//demo/home/txtName").getText()).sendKeys("standard_user");
	  findById(doc.selectSingleNode("//demo/home/txtPass").getText()).sendKeys("secret_sauce");
	  findById(doc.selectSingleNode("//demo/home/btnLogin").getText()).click();	  
  }
  
  public WebElement findById(String str)
  {
	  return driver.findElement(By.id(str));
  }
}
