package Selenium_Learning;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpliLearn_loginPage {
    public WebDriver driver;
    public static void main(String args[]) throws Exception{
        SimpliLearn_loginPage obj = new SimpliLearn_loginPage();
        obj.launchApplication();
        //obj.doSomeTestScenarioValidation();
        //obj.closeApplication();

}
public void launchApplication(){
    System.setProperty("webdriver.chrome.driver"
            , "C:\\Users\\vinut\\chromedriver_win32\\chromedriver.exe"); // To set Chrome Driver path in System properties

    driver = new ChromeDriver(); // This will launch your Chrome Browser
    driver.manage().window().maximize(); // This will Maximize the Browser
    driver.get("https://lms.simplilearn.com/"); // To Launch The Google Application

    System.out.println(" User Successfully launched simplilearn Application .....");

    }
// Open SimpliLearn
    //Validate Log In Button
    // You are in Login Page , type any Email
    //. Type Password
    //. Validate Login button
    //Validate Google , Facebook , LinkEdIn , Apple
}
