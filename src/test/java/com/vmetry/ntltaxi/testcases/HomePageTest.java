package com.vmetry.ntltaxi.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initaliser.Initializer;
import com.vmetry.ntltaxi.inputreader.inputReader;
import com.vmetry.ntltaxi.pages.HomePage;
import com.vmetry.ntltaxi.reports.ScreenshotGenerator;

public class HomePageTest extends Initializer {
	@BeforeTest
	public void setup() throws IOException
	{
		initialize();
	}
	@Test(dataProvider="HomePageTest")
	public void validateHomePage(String data,String username,String mobilenumber,String pickup,String drop,String selectdrop) throws IOException {
		log=report.startTest(data);
		wd.get(envProp.getProperty("URL"));
		/*wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[2]")).sendKeys("Vmetry");
		wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[3]")).sendKeys("8144887890");
	    wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[5]")).sendKeys("ADYAR");
        wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[6]")).sendKeys("GUINDY");
		WebElement dropdown=wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/select"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("Sedan");
        wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[7]")).click();*/
		/*getWebeElementByXpath("HomePage_UserName_Type_Xpath").sendKeys("Vmetry");
		getWebeElementByXpath("HomePage_MonileNumber_Type_Xpath").sendKeys("1234567898");
		getWebeElementByXpath("HomePage_PickUpPlace_Type_Xpath").sendKeys("ADYAR");
		getWebeElementByXpath("HomePage_DropPlace_Type_Xpath").sendKeys("GUINDY");
		getWebeElementByXpath("HomePage_Select_Type_Xpath").sendKeys("Sedan");
		getWebeElementByXpath("HomePage_Click_Type_Xpath").click();*/
		HomePage.enterusername(wd,username);
		HomePage.entermobilenumber(wd, mobilenumber);
		HomePage.pickupplace(wd, pickup);
		HomePage.dropplace(wd, drop);
		HomePage.dropdown(wd, selectdrop);
		HomePage.clickbooklater(wd);
		}
	@DataProvider(name="HomePageTest")
	public static Object[][] gethomepagedata() throws Exception
	{
		if(inputReader.RunModeVerification("HomePageTest")){
		Object[][] data=inputReader.selectSingleDataOrMulitiData("HomePageTest");
		//first set data
		/*data[0][0]="Vmetry";
		data[0][1]="7894561232";
		data[0][2]="ADYAR";
		data[0][3]="GUINDY";
		data[0][4]="Sedan";
		//second set
		data[1][0]="Kanmani";
		data[1][1]="7894561232";
		data[1][2]="ADYAR";
		data[1][3]="GUINDY";
		data[1][4]="Sedan";
		//third set data
		data[2][0]="Kannu";
		data[2][1]="7894561232";
		data[2][2]="ADYAR";
		data[2][3]="GUINDY";
		data[2][4]="Sedan";*/
		
		return data;
		
	}
		return null;
	}
		@AfterMethod
		public void teardown(ITestResult it) throws IOException{//Itestresults will check to take screen shots of failed testcases
		    
		    if(it.isSuccess())
		    {
		    	ScreenshotGenerator.attachscreenshot(it);
		    }
		    else
		    {
		    	ScreenshotGenerator.attachscreenshot(it);
		    }
		    
		
}
	}
