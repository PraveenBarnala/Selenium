package first;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Practice 
{
  public static String projectpath=System.getProperty("user.dir");
  public static FileInputStream f;
  public static Properties p;
  public static Properties pr;
  public static Properties pro;
  public static Properties prop;
  public static WebDriver driver;

	public static void init() throws IOException
	{
		  f = new FileInputStream(projectpath+"\\data.properties");
		  p= new Properties();
		  p.load(f);
		  
		  f = new FileInputStream(projectpath+"\\environment.properties");
		  pr= new Properties();
		  pr.load(f);
		  String e=pr.getProperty("env");
		  
		  f = new FileInputStream(projectpath+"\\"+e+".properties");
		  pro= new Properties();
		  pro.load(f);
		  
		  f = new FileInputStream(projectpath+"\\or.properties");
		  prop= new Properties();
		  prop.load(f);

	}
	
	public static void launch(String browser) 
	{
		if(p.getProperty(browser).equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",projectpath+"\\drivers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\pc\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
			 driver =new ChromeDriver(option);
			
		}
		if(p.getProperty(browser).equals("firefox")) 
		{
			System.setProperty("webdriver.chrome.driver",projectpath+"\\drivers\\chromedriver.exe");
			 driver =new ChromeDriver();
			
			
		}
	}
	
	public static void url(String url) 
	{
		driver.get(pro.getProperty(url));
	}
	
    public static void selectOption(String locatorkey,String option)
    {
    	
    	getElement(locatorkey).sendKeys(option);
    }
    
    public static void enterText(String locatorkey,String option)
    {
    	
    	getElement(locatorkey).sendKeys(option);
    }
    
    public static void search(String locatorkey)
    {
    	 getElement(locatorkey).click();
    }

	public static WebElement getElement(String locatorkey) {
		if(!isElementFound(locatorkey)) {
			System.out.println("Element not found");}
		
		WebElement loc =null;		
		loc=driver.findElement(getLocator(locatorkey));		
		return loc;	
		
	}
	
	public static boolean isElementFound(String locatorkey) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	
	try {
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
	} catch (Exception e) {
		return false;
	}
	return true;
	}

	public static By getLocator(String locatorkey) {
		// TODO Auto-generated method stub
		By by=null;
		if(locatorkey.endsWith("_id")) {
		by=(By.id(prop.getProperty(locatorkey)));}
		else if(locatorkey.endsWith("_name"))
	    by=(By.name(prop.getProperty(locatorkey)));
		else if(locatorkey.endsWith("_xpath"))
		by=(By.xpath(prop.getProperty(locatorkey)));
		
		
		return by;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}