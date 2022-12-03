package Selenium_Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogle {
    public WebDriver driver;
    public static void main(String args[]) throws Exception{
        TestGoogle obj = new TestGoogle();
        obj.launchApplication();
        obj.doSomeTestScenarioValidation();
        obj.closeApplication();


    }
    public void launchApplication(){
        System.setProperty("webdriver.chrome.driver"
                , "C:\\Users\\vinut\\chromedriver_win32\\chromedriver.exe"); // To set Chrome Driver path in System properties

        driver = new ChromeDriver(); // This will launch your Chrome Browser
        driver.manage().window().maximize(); // This will Maximize the Browser
        driver.get("https://www.google.com"); // To Launch The Google Application

        System.out.println(" User Successfully launched Google Application .....");




    }
     public void doSomeTestScenarioValidation(){
        // validate Google logo is present ot not ...

        if (driver.findElement(By.className("lnXdpd")).isDisplayed())

        {
            System.out.println("Google Logo is displayed ..."+ "PASS");

        }
        else
            System.out.println("Google Logo is not displayed ..."+ "FAIL");

     if (driver.findElements(By.name("btnK")).size()>0)
     {
         System.out.println("search is displayed ..."+ "PASS");
     }
     else
         System.out.println("Google search is not displayed ..."+ "FAIL");
     //
        if(driver.findElement(By.name("q")).isDisplayed())
        {
            driver.findElement(By.name("q")).sendKeys("Software Testing");
            
        }
        else
            System.out.println(" Not able to type");

    }
    public void closeApplication()
    {
        driver.quit(); // To Quit the Driver session / Close the Chrome Browser .
    }
}

