package first;

import java.io.IOException;



	public class Tc_2 extends BrowserLaunching{
		
		
		public static void main(String[] args) throws IOException, InterruptedException  {
			init();
			//launch("Firefoxbrowser");
			launch("chromebrowser");
			navigateurl("url2");
			
//			launch("Firefoxbrowser");
//			navigateurl("url2");
		}

	}


