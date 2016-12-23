package com.vmetry.ntltaxi.initaliser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.math.IEEE754rUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vmetry.ntltaxi.reports.ReportGenerator;

public class Initializer {
	public static ExtentReports report;//to generate reports
	public  static ExtentTest log;//store logs
	/**
	 * declaring env property variables
	 * @author KANMANI
	 */
	public static FileInputStream envFis=null;
	public static Properties envProp=null;
	/**
	 * declaring locator properties variable
	 * @author KANMANI
	 */
	public static FileInputStream locatorFis=null;
	public static Properties locatorProp=null;
	
	public static WebDriver wd=null;
	public static boolean isArchive=true;
	public static void initialize() throws IOException{
		ReportGenerator.archivefile();
		report =new ExtentReports("C:\\SeleniumWorkspace\\DDDTest\\reports\\report.html");

envFis=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"env.properties"));
envProp=new Properties();
envProp.load(envFis);

locatorFis=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"locator.properties"));
locatorProp=new Properties();
locatorProp.load(locatorFis);
if(envProp.getProperty("BROWSER").equals("FIREFOX")){
wd=new FirefoxDriver();	
}
else if(envProp.getProperty("BROWSER").equals("CHROME")){
	wd=new ChromeDriver();
}

else if (envProp.getProperty("BROWSER").equals("IE")){
wd=new InternetExplorerDriver();		
}
}
public static WebElement getWebeElementByXpath(String Xpath){
	return wd.findElement(By.xpath(locatorProp.getProperty(Xpath)));
	
}
}
