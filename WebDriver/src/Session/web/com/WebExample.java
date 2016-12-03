package Session.web.com;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Library.Utilty;



public class WebExample {

	@Test 
public static void main(String arg[]) throws Exception 
{
	String Browser =JOptionPane.showInputDialog("Please enter Browser name");
WebDriver Driver=launchBrowser(Browser);

	Logger logger = Logger.getLogger(WebExample.class);
	PropertyConfigurator.configure("log4j.properties");
	
	//System.setProperty("webdriver.chrome.driver", "E://Selenium Class/chromedriver.exe");  
	//ChromeDriver Driver = new ChromeDriver();
	  
	//driver.get("https://webmail.qainfotech.com");
	  //WebElement  nname = driver.findElementByName("username");
	  //nname.clear();
	  //nname.sendKeys("nitishsajnani@qainfotech.com");

		//WebElement ppass = driver.findElementByXPath(".//*[@id='password']");
		//ppass.clear(); 
		//ppass.sendKeys("N_989963989");
		
		
		
		//WebElement th = driver.findElementById("Theme");
		//Select theme =new Select(th);
		//theme.selectByIndex(2);
		
		//WebElement la = driver.findElementById("Lang");
		//Select lang =new Select(la);
		//lang.selectByValue("en");
		
		
		
		//driver.findElementById("Logon").click();
		
	//DesiredCapabilities cap = DesiredCapabilities.firefox();
//cap.setPlatform(Platform.WINDOWS);
//		URL url = new  URL("http:localhost:4444/wd/hub");
//WebDriver Driver= new RemoteWebDriver(url,cap);
	logger.info("Driver launched ");
	
	
	Driver.get("https://www.goibibo.com/");
	logger.info("Url opened ");

WebElement home = Driver.findElement(By.xpath(".//*[@id='hd_user_widdget']/div[1]/i"));
//home.click();	
Actions homec =	new Actions(Driver);


homec.clickAndHold(home).build().perform();
logger.info("clicked signin page ");
WebElement sign = Driver.findElement(By.linkText("Sign In"));
homec.click(sign).build().perform();	

Utilty.captureScreenshot(Driver,"login");
WebElement fr =Driver.findElement(By.id("authiframe"));
Driver.switchTo().frame(fr);
WebElement loginId = Driver.findElement(By.xpath(".//*[@id='id_username']"));
loginId.clear();
loginId.sendKeys("nitish.sajnani18@gmail.com");
logger.info("enter email ID");
WebElement pass =Driver.findElement(By.xpath(".//*[@id='id_password']"));
pass.sendKeys("Nitish@9899");
Utilty.captureScreenshot(Driver,"pasd");
logger.info("Enter password ");	
WebElement  login = Driver.findElement(By.xpath(".//*[@id='signinBtn']"));
login.click();	
Utilty.captureScreenshot(Driver,"home");			  

//List<WebElement> allelement = Driver.findElements(By.xpath("//Div[@class='mainLinks']//a"));
//int countelements = allelement.size();
//System.out.println(countelements);
Driver.findElement(By.xpath("html/body/div[5]/div[2]/div[4]/div[1]/a[1]")).click();;
Driver.findElement(By.xpath("html/body/div[5]/div[2]/div[4]/div[1]/a[2]")).click();
Set<String> windelement = Driver.getWindowHandles();
Iterator<String> Windowselectelement= windelement.iterator();
while(Windowselectelement.hasNext()==true)
{
	String handelement =Windowselectelement.next();
	Driver.switchTo().window(handelement);
	String title =Driver.getTitle();
	if(title.contains("Ibibo Group")==true)
		{
		break;
		}

	else{
		Driver.close();
		
	}
}

Driver.findElement(By.xpath("html/body/div[10]/div/div/div/ul/li[3]/a/span")).click(); 
}


public static WebDriver launchBrowser(String brname) {

	
	WebDriver Driver =null;
	if(brname.equalsIgnoreCase("firefox")== true) {
		 

		Driver =new FirefoxDriver();
		
	}
	
	else
	{
		System.setProperty("webdriver.chrome.driver", "E://Selenium Class/chromedriver.exe");  

 Driver = new ChromeDriver();
	}
	return Driver;
}	// TODO Auto-generated method stub
	
}

