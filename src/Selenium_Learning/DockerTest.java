package Selenium_Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import reusable.actionClass;

public class DockerTest {

    public WebDriver driver;
    public actionClass obj;



    public static void main(String args[]) throws Exception{

        DockerTest obj = new DockerTest();
        obj.launchApplication();
        obj.doSomeTestScenarioValidation();
        obj.closeApplication();
    }


    // This method will launch Google Application ...

    public void launchApplication(){


        System.setProperty("webdriver.chrome.driver","C:\\Users\\vinut\\chromedriver_win32\\chromedriver.exe"); // To set Chrome Driver path in System properties

        driver = new ChromeDriver(); // This will launch your Chrome Browser
        driver.manage().window().maximize(); // This will Maximize the Browser
        driver.get("https://www.docker.com"); // To Launch The Google Application

        System.out.println(" User Successfully launched docker Application .....");

        obj = new actionClass(driver);



    }

    // Will do some test case validtion here ....

    public void doSomeTestScenarioValidation() throws Exception{

        // Mouse Hover on Products Header Menu Link

        obj.MouseHover(By.xpath("(//a[text()='Products'])[1]"));


        // Mouse Hover on Developers Header Menu Link

        obj.MouseHover(By.xpath("(//a[text()='Developers'])[1]"));


        // Mouse Hover on About US Header Menu Link


        obj.MouseHover(By.xpath("(//a[text()='About Us'])[1]"));


        // Validate Footer Social Media Options ..

        int medialinkCount = driver.findElements(By.xpath("//ul[@class='social-wrap']/li")).size();
        // To print All links ..
        System.out.println("medialinkCount is :"+medialinkCount);
        for (int i = 1; i <= medialinkCount; i++) {
            String linkName = driver.findElement(By.xpath("(//ul[@class='social-wrap']/li/a/img)["+i+"]")).getAttribute("src");
            System.out.println("When src is" + " " + i + " " + "Then src name is =>" + linkName);
        }

        // Validate 2022 inside copywright text ..

        if(obj.getTheText(By.xpath("//p[contains(.,'All rights reserved')]")).contains("2022")){

            System.out.println("The Copywright text is having 2022 as current year ....");
        }
        else
            System.out.println("The Copywright text is not having 2022 as current year ....");

// Added on nov 20th
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

        driver.quit(); // To Quit the Driver session / Close the Chrome Browser
    }
}
