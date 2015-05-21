package BaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by HP on 5/17/2015.
 */
public class Base {

    public WebDriver driver=null;
    @Parameters({"SauceLab","UserName","Key","BrowserName","BrowserVersion","os","url"})

    @BeforeMethod
    public void setUp(Boolean SauceLab,String UserName,String Key,String BrowserName,
                      String BrowserVersion,String os,String url)throws IOException{

        if(SauceLab==true){
            setUpCloudEnvironment(UserName,Key,BrowserName,BrowserVersion,os,url);
        }
        else{
            setUpLocalEnvironment(BrowserName,BrowserVersion,url);
        }
    }

    public void setUpCloudEnvironment(String UserName,String Key,String BrowserName,
                                      String BrowserVersion,String os,String url)throws IOException{

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName(BrowserName);
        cap.setCapability("version",BrowserVersion);
        cap.setCapability("platform",os);
        this.driver=new RemoteWebDriver(new URL("http://"+UserName+":"+Key+"@ondemand.saucelabs.com:80/wd/hub"),cap);
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void setUpLocalEnvironment(String BrowserName,
                                      String BrowserVersion,String url){
        if(BrowserName.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }
        else if(BrowserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","../Common/Selenium-Driver/chromedriver.exe");
            driver=new ChromeDriver();
        }

        else if(BrowserName.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver","../Common/Selenium-Driver/IEDriverServer.exe");
            driver=new ChromeDriver();
        }
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }


    //Utility Method

    public void clickByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void typeByCss(String locator,String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public void typeByXpath(String locator,String value){
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    public void typeAndEnterByCss(String locator,String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public void typeAndEnterByXpath(String locator,String value){
        driver.findElement(By.xpath(locator)).sendKeys(value,Keys.ENTER);
    }

    public List<String> getListOfTextByCss(String locator){
        List<WebElement> elements=driver.findElements(By.cssSelector(locator));
        List<String> text=new ArrayList<String>();
        for(WebElement wb:elements){
            text.add(wb.getText());
        }
        return text;
    }

    public void displayText(List<String> text){
        for(String st:text){
            System.out.println(st);
        }
    }

    public List<WebElement> getWebElements(String locator){
        List<WebElement> elements=driver.findElements(By.cssSelector(locator));
        return elements;
    }

    public List<WebElement> getWebElementsByXpath(String locator){
        List<WebElement> elements=driver.findElements(By.xpath(locator));
        return elements;
    }

    public void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public void mouseOver(List<WebElement> elements)throws InterruptedException{
        for(WebElement wb:elements){
            Actions action=new Actions(driver);
            action.moveToElement(wb).build().perform();
            sleepFor(2);
        }
    }

    public String getTextByCss(String locator){
        String text=driver.findElement(By.cssSelector(locator)).getText();
        return text;
    }

    public void clickByText(String locator) throws InterruptedException {
        driver.findElement(By.linkText(locator)).click();
        sleepFor(2);
    }

    public String getTextByXpath(String locator){
        String st=driver.findElement(By.xpath(locator)).getText();
        return st;
    }



}
