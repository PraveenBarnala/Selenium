package first;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

public class T1 extends Practice{
			
	public static void main(String[] args) throws IOException {
		init();
		launch("chromebrowser");
	driver.manage().window().maximize();
		url("url1");
		selectOption("amazondropdown_id","Books");
		
		enterText("amazontextfield_xpath","gate previous year");
		search("amazonsearch_xpath");
	}	  
		
		

	
}