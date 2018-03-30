package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePage.Base;

public class LoginPage {

	public static String signup=".//*[@id='gosuggest_inputSrc']";
	
	public static void login(){
		Base.driver.findElement(By.xpath("fff")).sendKeys("test");
		List<WebElement> l=Base.driver.findElements(By.xpath("cdcd"));
		for(WebElement l1:l){
			System.out.println(l1.getText());//jjyujyu
		
			
			
		}
		
	}
	

}
