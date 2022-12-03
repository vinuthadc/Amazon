package Selenium_Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import reusable.Reusable;
import reusable.actionClass;

public class DragAndDrop {

    public WebDriver driver;
    public actionClass obj;
    public static Reusable res ;



    public static void main(String args[]) throws Exception{

        DragAndDrop obj = new DragAndDrop();
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




        // How to do Drag and Drop ...


        obj.ClickAndWait(By.xpath("//a[text()='Drag and Drop']"));

        WebElement what_To_Drag = driver.findElement(By.xpath("//div[@id='column-a']/header[text()='A']"));
        WebElement Where_To_Drop = driver.findElement(By.xpath("//div[@id='column-b']/header[text()='B']"));

        Actions test = new Actions(driver);
        test.dragAndDrop(what_To_Drag , Where_To_Drop).build().perform();
        Thread.sleep(5000);

        WebElement sourcePro = driver.findElement(By.xpath("//div[@id='column-a']/header[text()='B']"));
        WebElement DestPro = driver.findElement(By.xpath("//div[@id='column-b']/header[text()='A']"));

        if(sourcePro.isDisplayed() && DestPro.isDisplayed())
        {
            System.out.println("DRAG and DROP is Success");
        }
        else {
            System.out.println("DRAG and DROP Failed .....");
        }
    }

    // Will close the Application

    public void closeApplication(){
        driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..
    }



}
