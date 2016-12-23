package com.vmetry.ntltaxi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vmetry.ntltaxi.initaliser.Initializer;

public class HomePage extends Initializer {
	public static void loadurl(WebDriver wd)
	{
		wd.get("http://www.ntltaxi.com/");
		}
	public static void enterusername(WebDriver wd,String username)
	{
		//wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[2]")).sendKeys(username);
		getWebeElementByXpath("HomePage_UserName_Type_Xpath").sendKeys(username);
	}
	public static void entermobilenumber(WebDriver wd,String mobilenumber){
	//wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[3]")).sendKeys("8144887890");
		getWebeElementByXpath("HomePage_MonileNumber_Type_Xpath").sendKeys(mobilenumber);
	}
	public static void pickupplace(WebDriver wd,String pick){
		//wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[5]")).sendKeys("ADYAR");
		getWebeElementByXpath("HomePage_PickUpPlace_Type_Xpath").sendKeys(pick);
	}
	public static void dropplace(WebDriver wd,String drop){
		//wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[6]")).sendKeys("GUINDY");
		getWebeElementByXpath("HomePage_DropPlace_Type_Xpath").sendKeys(drop);
	}
	public static void dropdown(WebDriver wd,String select){
		/*WebElement dropdown=wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/select"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("Sedan");*/
		getWebeElementByXpath("HomePage_Select_Type_Xpath").sendKeys(select);
	}
	public static void clickbooklater(WebDriver wd){
		//wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[7]")).click();
		getWebeElementByXpath("HomePage_Click_Type_Xpath").click();
	}
}
