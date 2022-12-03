package Selenium_Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import reusable.Reusable;
import reusable.actionClass;

public class cssElementRead {

    public WebDriver driver;
    public actionClass obj;
    public static Reusable res ;



    public static void main(String args[]) throws Exception{

        cssElementRead obj = new cssElementRead();
        res = new Reusable();
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
        driver.get("https://the-internet.herokuapp.com/"); // To Launch The Google Application

        System.out.println(" User Successfully launched herokuapp Application .....");

        obj = new actionClass(driver);
    }

    // Will do some test case validtion here ....

    public void doSomeTestScenarioValidation() throws Exception{




        // Capture font size , text color , bg color of Get Started button ...

        WebElement ele = By.xpath("//a[text()='Learn Kubernetes Basics']").findElement(driver);

        String fnt_size = ele.getCssValue("font-size");
        String color = ele.getCssValue("color");
        String bg_color = ele.getCssValue("background-color");

        System.out.println(" The Font size is ===>"+fnt_size );
        System.out.println(" The text Color is ===>"+color );
        System.out.println(" The text BG Color is ===>"+bg_color );

    }

    // Will close the Application

    public void closeApplication(){
        driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..
    }



}


