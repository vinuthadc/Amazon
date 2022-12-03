package Selenium_Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Screen;
import reusable.actionClass;

import java.util.Iterator;
import java.util.Set;

public class SukulliTest {

    public WebDriver driver;
    public actionClass obj;



    public static void main(String args[]) throws Exception{

        SukulliTest obj = new SukulliTest();
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
        driver.get("https://the-internet.herokuapp.com/basic_auth"); // To Launch The Google Application
        System.out.println(" User Successfully launched herokuapp Application .....");
        obj = new actionClass(driver);
    }

    // Will do some test case validtion here ....

    public void doSomeTestScenarioValidation() throws Exception{


        Screen test = new Screen();

       // test.exists("");
        //test.exists("\\");

       // test.type("C:\\Users\\vinut\\Desktop\\Sikuli Images\\uname" , "username");
        //Thread.sleep(5000);
        //test.type("/Users/vinut/Downloads/SikuliImages/password.jpg" , "Password");
        //Thread.sleep(5000);



    }

    // Will close the Application

    public void closeApplication(){
        driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..
    }



}








