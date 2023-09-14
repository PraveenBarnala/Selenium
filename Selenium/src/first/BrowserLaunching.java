package first;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserLaunching {
	
	
	public static String projectpath= System.getProperty("user.dir");
	public static FileInputStream f;
	public static Properties p;
	public static Properties pr;
	public static Properties pro;
	public static WebDriver driver;
	
	public static void init() throws IOException   {
		
		 f= new FileInputStream(projectpath+"\\data.properties");
		  p= new Properties();
		 p.load(f);
	

		  f= new FileInputStream(projectpath+"\\environment.properties");
		  pr= new Properties();
		  pr.load(f);
		  String e=pr.getProperty("env");
		  
		  f= new FileInputStream(projectpath+"\\"+e+".properties");
		  pro= new Properties();
		  pro.load(f);
		  
	}
	
	public static void launch(String browser) throws IOException
	{
		
		
	     if(p.getProperty(browser).equals("chrome")) {
	    System.setProperty("webdriver.chrome.driver",projectpath+"\\drivers\\chromedriver.exe");
	    ChromeOptions options =new ChromeOptions();
	    options.addArguments("user-data-dir=C:\\Users\\pc\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
	    driver = new ChromeDriver(options);
	    options.addArguments("--disable-notificactions");
	    
	     }
	   else if(p.getProperty(browser).equals("firefox")) {
		   System.setProperty("webdriver.chrome.driver",projectpath+"\\drivers\\chromedriver.exe");
	      driver = new ChromeDriver();
	   }
	}
	
	
	public static void navigateurl(String url) throws InterruptedException {
		
	driver.navigate().to(pro.getProperty(url));
	driver.manage().window().maximize();
	String s=driver.getTitle();
	System.out.println(s);
	String st =driver.getCurrentUrl();
	System.out.println(st);
	String str=driver.getWindowHandle();
	System.out.println(str);
	driver.getPageSource();
	driver.navigate().forward();
	Thread.sleep(6000);
	driver.navigate().back();
	Thread.sleep(6000);
	driver.manage().deleteAllCookies();
	driver.quit();
		}
}

