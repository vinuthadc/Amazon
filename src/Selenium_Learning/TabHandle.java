package Selenium_Learning;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import reusable.actionClass;
import java.util.ArrayList;

 public class TabHandle {

    public WebDriver driver;
    public actionClass obj;



    public static void main(String args[]) throws Exception{

        TabHandle obj = new TabHandle();
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
        driver.get("https://www.google.com/"); // To Launch The Google Application

        System.out.println(" User Successfully launched Google Application .....");

        obj = new actionClass(driver);



    }

    // Will do some test case validtion here ....

    public void doSomeTestScenarioValidation() throws Exception{

        // First I will Launch Google === DOne ..

        // Then Open a new TAB --> Open Twitter

        ((JavascriptExecutor)driver).executeScript("window.open()");

        Thread.sleep(5000);

        // We need to  Capture How many Tabs we have ..

        ArrayList<String> Tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(Tabs.get(1));

        driver.navigate().to("https://twitter.com/");

        /// Capture Twitter Page Title

        String TwitterTitle = driver.getTitle();


        // Close Twitter TAB

        driver.close();



        // Move Back to Google Tab ..

        driver.switchTo().window(Tabs.get(0));


        // COme to Google Window and Type Twitter Title ...

        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys(TwitterTitle);

        Thread.sleep(10000);



    }

    // Will close the Application

    public void closeApplication(){

        driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

    }



}








