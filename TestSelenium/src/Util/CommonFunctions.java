package Util;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpConnection;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.Base;
public class CommonFunctions {

	public void takeScreenShot(String FileName){
		TakesScreenshot ts=(TakesScreenshot)(Base.driver);
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(".\\src\\ScreenShot\\"+FileName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doubleClick(){
		WebElement el=Base.driver.findElement(By.xpath("ss"));
		Actions ac=new Actions(Base.driver);
		ac.moveToElement(el).build().perform();
	}
	public void dragAndDrop(){
		WebElement el=Base.driver.findElement(By.xpath("ss"));
		WebElement el1=Base.driver.findElement(By.xpath("ss"));
		Actions ac=new Actions(Base.driver);
		ac.dragAndDrop(el, el1);
	}
	public void javaScriptExecutor(){
		WebElement el=Base.driver.findElement(By.xpath("ss"));
		JavascriptExecutor js= (JavascriptExecutor)Base.driver;
		js.executeScript("arguments[0].click()", el);
	}
	public void withoutSendKeys(){
		WebElement el=Base.driver.findElement(By.xpath("ss"));
		JavascriptExecutor js=(JavascriptExecutor)Base.driver;
		js.executeScript("document.getElementById('xpath').value='test'");
	}
	public void scrollToView(){
		WebElement el=Base.driver.findElement(By.xpath("ss"));
		JavascriptExecutor js=(JavascriptExecutor)Base.driver;
		js.executeScript("arguments[0].scrollIntoView()", el);
	}
	public void clickHidden(){
		WebElement el=Base.driver.findElement(By.xpath("ss"));
		JavascriptExecutor js=(JavascriptExecutor)Base.driver;
		js.executeScript("document.getElementById('id').click()");
	}
	public void brokenlink(){
		List<WebElement> link=Base.driver.findElements(By.tagName("\\a"));
		for(WebElement l:link){
			try {
				URL url=new URL(l.getAttribute("href"));
				HttpURLConnection cn=(HttpURLConnection)url.openConnection();
				cn.setConnectTimeout(30);
				cn.connect();
				if(cn.getResponseCode()!=200){
					System.out.println(url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void SelectDropdown(){
		WebElement el=Base.driver.findElement(By.xpath("ss"));
		Select s=(Select)Base.driver;
		s.selectByVisibleText("test");
		
	}
	public void dbConnection(){
		try {
			Class.forName("driver");
			Connection cn=DriverManager.getConnection("path","user","pass");
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("sql");
			while(rs.next()){
				System.out.println(rs.getString("clomnname"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void switchToFrame(){
		Base.driver.switchTo().frame("id");
		Base.driver.switchTo().defaultContent();
	}
	public void windowHandle(){
		Base.driver.getWindowHandle();
		Base.driver.getWindowHandles();
	}
	public void alert(){
		Base.driver.switchTo().alert().accept();
	}
	
}
