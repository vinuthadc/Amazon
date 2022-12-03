package Selenium_Learning;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Screen;
import reusable.*;

public class FIleUpload {

    public WebDriver driver;
    public actionClass obj;
    public static Reusable res ;



    public static void main(String args[]) throws Exception{

        FIleUpload obj = new FIleUpload();
        res = new Reusable();
        obj.launchApplication();
        obj.doSomeTestScenarioValidation();
        obj.closeApplication();
    }


    // This method will launch Google Application ...

    public void launchApplication(){
        System.setProperty("webdriver.chrome.driver"
                ,("C:\\Users\\vinut\\chromedriver_win32\\chromedriver.exe")); // To set Chrome Driver path in System properties
        driver = new ChromeDriver(); // This will launch your Chrome Browser
        driver.manage().window().maximize(); // This will Maximize the Browser

        driver.get("https://the-internet.herokuapp.com/");
       // driver.get(res.readPropertiesFile("url")); // To Launch The Google Application
        System.out.println(" User Successfully launched herokuapp Application .....");
        obj = new actionClass(driver);
    }

    // Will do some test case validtion here ....

    public void doSomeTestScenarioValidation() throws Exception{


        // Uploading an Image using Selenium ....

        driver.findElement(By.id("file-upload")).sendKeys("/C:/Users/vinut/Desktop/Sikuli Images/DockerLogo.png");

        // Now click on

        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(5000);

        if (driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed()
                && driver.findElement(By.xpath("//div[contains(.,'DockerImage.png') and @id='uploaded-files']")).isDisplayed())
        {
            System.out.println("Image uploaded is Success!!!!!!");
        }
        else
        {
            System.out.println("Image uploaded is Fail!!!!!!");
        }


        // Capture the Screenshot if test fails ....


        driver.navigate().to("https://www.docker.com");

        Thread.sleep(8000);

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());


        // Validate Get Started Button ...

        try{

            driver.findElement(By.xpath("(//a[text()='Get Startedz'])[1]")).isDisplayed();

        }
        catch(Exception e)
        {
            e.printStackTrace();
            obj.takeTheScreenShot("GetStartedButton");
        }







    }

    // Will close the Application

    public void closeApplication(){
        driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..
    }



}
