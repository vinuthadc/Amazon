package Selenium_Learning;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.json.JsonOutput;
import reusable.actionClass;

public class woundcaremd {
    public WebDriver driver;
    public actionClass obj;
    public static void main(String args[]) throws Exception{

        woundcaremd obj = new woundcaremd();
        obj.launchApplication();
        obj.doSomeTestScenarioValidation();
        obj.closeApplication();
    }

    public void launchApplication(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vinut\\chromedriver_win32\\chromedriver.exe"); // To set Chrome Driver path in System properties

        driver = new ChromeDriver(); // This will launch your Chrome Browser
        driver.manage().window().maximize(); // This will Maximize the Browser
        driver.get("https://www.woundcaremd.com"); // To Launch The Google Application

        System.out.println(" User Successfully launched wcmd Application .....");
        obj = new actionClass(driver);
    }
    public void doSomeTestScenarioValidation()
    {
        //To check woundcaremd logo on login page

        obj.checkForElementPresent(By.xpath("//img[@src='img/logo.png']"));
        //obj.checkForElementPresent(By.xpath("//img[@src='assets/custom/image/wcmd-logo-black.png']"));
        System.out.println("wcmd logo is present");
        System.out.println("The Current Page Title =="+ driver.getTitle());
        System.out.println("The Current TAB URL =="+ driver.getCurrentUrl());
        obj.MouseHover(By.xpath("//a[contains(.,'WCMD 2.0')]"));
        obj.MouseHover(By.xpath("//a[contains(.,'WCMD 3.0')]"));
        obj.MouseHover(By.xpath("//a[contains(.,'Training')]"));
        //obj.MouseHover(By.xpath("//a[contains(.,'//a[contains(.,'INNOVATIVE HEALING SYSTEMS')]')]"));

        //int count=driver.findElements(By.xpath("//div//a[contains(.,'WCMD 3.0')]")).size();
        int linkCount=driver.findElements(By.tagName("a")).size();
        //System.out.println(count);
        System.out.println(linkCount);


    }
    public void closeApplication(){

        driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

    }
}
