package Selenium_Learning;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import reusable.actionClass;

public class DocketTest_HeadlessMode {

    public WebDriver driver;
    public actionClass obj;



    public static void main(String args[]) throws Exception{

        DocketTest_HeadlessMode obj = new DocketTest_HeadlessMode();
        obj.launchApplication();
        obj.doSomeTestScenarioValidation();
        obj.closeApplication();
    }


    // This method will launch Google Application ...

    public void launchApplication(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        System.setProperty("webdriver.chrome.driver"
                , "C:\\Users\\vinut\\chromedriver_win32\\chromedriver.exe"); // To set Chrome Driver path in System properties

        driver = new ChromeDriver(options); // This will launch your Chrome Browser
        driver.manage().window().maximize(); // This will Maximize the Browser
        driver.get("https://www.docker.com"); // To Launch The Google Application

        System.out.println(" User Successfully launched docker Application .....");

        obj = new actionClass(driver);



    }

    // Will do some test case validtion here ....

    public void doSomeTestScenarioValidation(){

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





    }

    // Will close the Application

    public void closeApplication(){

        driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

    }



}


