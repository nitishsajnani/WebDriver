import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class DemoS {

	public static void main(String[] Args) throws FindFailed
	{

		Screen screen =new Screen();
		Pattern pattern1 =  new Pattern("C:\\Users\\NITISH\\Desktop\\Imagess\\Image1.png");
		Pattern pattern2 =  new Pattern("C:\\Users\\NITISH\\Desktop\\Imagess\\Image2.png");
		Pattern pattern3 =  new Pattern("C:\\Users\\NITISH\\Desktop\\Imagess\\Image3.png");
		Pattern pattern4 =  new Pattern("C:\\Users\\NITISH\\Desktop\\Imagess\\Image4.png");
	System.setProperty("webdriver.chrome.driver", "E://Selenium Class/chromedriver.exe");  

	WebDriver driver= new ChromeDriver();
//		WebDriver driver= new FirefoxDriver();

	driver.get("http://www.goibibo.com");
	WebElement home = driver.findElement(By.xpath(".//*[@id='hd_user_widdget']/div[1]/i"));
	Actions homec =	new Actions(driver);


	homec.clickAndHold(home).build().perform();

	WebElement sign = driver.findElement(By.linkText("Sign In"));
	homec.click(sign).build().perform();	
	WebElement fr =driver.findElement(By.id("authiframe"));
	driver.switchTo().frame(fr);
	
	screen.type(pattern2,"nitish.sajnani18@gmail.com");
	screen.type(pattern3,"Nitish@9899");
	screen.click(pattern4);
	}
}
