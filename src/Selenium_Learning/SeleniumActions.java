package Selenium_Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumActions {

    public WebDriver driver;

    public static void main(String args[]) throws Exception {

        SeleniumActions obj = new SeleniumActions();
        obj.launchApplication();
        obj.doSomeTestScenarioValidation();
        //obj.printSrcOfAllImages();
        //obj.closeApplication();
       // obj.printAllLinks();
    }


    // This method will launch Google Application ...

    public void launchApplication() {


        System.setProperty("webdriver.chrome.driver"
                , "C:\\Users\\vinut\\chromedriver_win32\\chromedriver.exe"); // To set Chrome Driver path in System properties

        driver = new ChromeDriver(); // This will launch your Chrome Browser
        driver.manage().window().maximize(); // This will Maximize the Browser
        driver.get("https://www.simplilearn.com"); // To Launch The Google Application

        System.out.println(" User Successfully launched Google Application .....");

    }

    // Will do some test case validtion here ....

    public void doSomeTestScenarioValidation() {
        try {
            // Print All header menu options with its count...

           int headermenucount = driver.findElements(By.xpath("//div[@id='topsubmenu']/div/a")).size();

            // To print All header menu links ..

            for (int i = 1; i <= headermenucount; i++)
            {

                String linkName = driver.findElement(By.xpath("//div[@id='topsubmenu']/div/a[" + i + "]")).getText();

                System.out.println("When position is" + " " + i + " " + "Then Link Name is =>" + linkName);
                //Thread.sleep(milliseconds);
            }
            /// To print the Title for Request A Demo Button ..
            String title = driver.findElement(By.xpath("(//a[text()='Request a Free Demo'])[1]")).getAttribute("title");
            System.out.println("The Title value of Request a Free Demo button is ===>"+title);


        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void printAllLinks(){
        int allLiksCount = driver.findElements(By.xpath("//a")).size();
        // To print All links ..
        for(int i=1;i<=allLiksCount;i++) {
            String linkName = driver.findElement(By.xpath("(//a)["+i+"]")).getText();
            System.out.println("When Link position is" + " " + i + " " + "Then Link Name is =>" + linkName);
        }}


      public void printSrcOfAllImages()
      {
          int allImagecount = driver.findElements((By.xpath("//img"))).size();
          for(int i=1;i<=allImagecount; i++)
          {
              String imageName= driver.findElement(By.xpath("(//img)["+i+"]")).getAttribute("src");
              System.out.println("When position is" + " " + i + " " + "Then Link Name is =>" + imageName);
          }

      }
        public void closeApplication()
    {

        driver.quit(); // To Quit the Driver session / Close the Chrome Browser ..

    }

            }
                // Will close the Application}

