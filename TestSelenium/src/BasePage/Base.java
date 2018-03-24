package BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Base {
	public static WebDriver driver;
	public static Properties pr;
	public static FileInputStream fr;
	public boolean IsBrowserClosed=true;
	
	static{
		pr=new Properties();
		try {
			fr=new FileInputStream(".\\src\\Config\\config.properties");
			pr.load(fr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Base(String Browser, String URL){
		if(IsBrowserClosed==true || driver==null){
			if(Browser.equalsIgnoreCase("chrome")){
				System.setProperty("Webdriver.chrome.driver", ".\\chromerdriver.exe");
				ChromeOptions co=new ChromeOptions();
				co.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver=new ChromeDriver(co);
				driver.manage().window().maximize();
				driver.navigate().to(URL);
			
			}else if(Browser.equalsIgnoreCase("mozilla")){
				System.setProperty("Webdriver.gecko.driver", ".\\geckodriver.exe");
				FirefoxOptions fo=new FirefoxOptions();
				fo.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver=new FirefoxDriver(fo);
				driver.navigate().to(URL);
				driver.manage().window().maximize();
			}else if (Browser.equalsIgnoreCase("IE")){
				System.setProperty("WebDriver.IE.driver", ".\\IEDriverServer.exe");
				InternetExplorerOptions io=new InternetExplorerOptions();
				io.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver=new InternetExplorerDriver();
				driver.navigate().to(URL);
				
			}
			
		}
		IsBrowserClosed=false;
	}
	
}
