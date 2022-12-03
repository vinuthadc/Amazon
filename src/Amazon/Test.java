package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Test {
        public WebDriver driver;
    public static void main(String args[]) throws Exception{

        Test obj=new Test();
        obj.Launch();
        //obj.links();
        obj.perform_Action();
        obj.selectItem();
        obj.close();
    }

        private void Launch() {
            System.setProperty("webdriver.chrome.driver"
                    , "C:\\Users\\vinut\\chromedriver_win32\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in/");
            System.out.println(" User Successfully launched Amazon Application .....");
        }

       public void links() {
           int total_link = driver.findElements(By.xpath("//div[@id='nav-xshop']/a")).size();
           System.out.println("Total links in top menu are:" + total_link);

           for (int i = 1; i <= total_link; i++)
           {
             String  linkName = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[" + i + "]")).getText();
           System.out.println(linkName);}
       }
        public void perform_Action() {


            if (driver.findElement(By.id("twotabsearchtextbox")).isDisplayed())
            {
                System.out.println("Search box is displayed");
                driver.findElement(By.id("twotabsearchtextbox")).sendKeys("realme 9");

            }
            else
            {
                System.out.println("search button not displayed");
            }
            driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        }
        public void selectItem () throws Exception
        {
            if(driver.findElement(By.xpath("//span[contains(text(),'realme 9 (Meteor Black,6GB RAM, 128GB Storage)')]")).isDisplayed())
            {
                System.out.println("i-phone is available");
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[contains(text(),'realme 9 (Meteor Black,6GB RAM, 128GB Storage)')]")).click();

                driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
            }
            else {
                System.out.println("iphone not available");}}


            public void scroll(By element){
        {
                    try{

                        WebElement ele = driver.findElement(element);
                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" , ele);
                        Thread.sleep(5000);
                    }
                    catch(Exception e){e.printStackTrace();
                        System.out.println(element+"..... is not present to Scroll ...");}
                }

            }


        public void close(){

            driver.quit();}



    }
