package Selenium_Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import reusable.actionClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {

    public WebDriver driver;
    public actionClass obj;



    public static void main(String args[]) throws Exception{

        WindowHandle obj = new WindowHandle();
        obj.launchApplication();
        obj.doSomeTestScenarioValidation();
        obj.closeApplication();
    }


    // This method will launch Google Application ...

    public void launchApplication(){
        System.setProperty("webdriver.chrome.driver"
                , "C:\\Users\\vinut\\chromedriver_win32\\chromedriver.exe"); // To set Chrome Driver path in System properties
        driver = new ChromeDriver(); // This will launch your Chrome Browser
        driver.manage().window().maximize(); // This will Maximize the Browser
        driver.get("https://www.docker.com/"); // To Launch The Google Application
        System.out.println(" User Successfully launched Docker Application .....");
        obj = new actionClass(driver);
    }

    // Will do some test case validtion here ....

    public void doSomeTestScenarioValidation() throws Exception{
        // First We Need To Capture Parent Window Property as String ...
        String ParentWindow = driver.getWindowHandle();
        // Now I am Clicking on Twitter Logo ...
        WebElement ele = driver.findElement(By.xpath("//div[@id='footer']//ul[@class='social-wrap']//a[contains(@href,'twitter')]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);
        Thread.sleep(5000);
        ele.click();
        Thread.sleep(5000);
        // Return number of Windows opened by WebDriver and will return
        // Set of String ..
        Set<String> set = driver.getWindowHandles();
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()){
            String childWindow = itr.next();
            if(!ParentWindow.equals(childWindow))
            {
                driver.switchTo().window(childWindow);
                System.out.println(driver.getTitle());
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }
        }
        driver.switchTo().window(ParentWindow);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    // Will close the Application

    public void closeApplication(){
        driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..
    }



}








