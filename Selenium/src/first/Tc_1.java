package first;

import java.io.IOException;

public class Tc_1 extends BrowserLaunching{
	
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		init();
		//launch("Firefoxbrowser");
		launch("chromebrowser");
		navigateurl("url1");
		
//		launch("Firefoxbrowser");
//		navigateurl("url2");
	}

}
