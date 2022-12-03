package reusable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class actionClass {

    public WebDriver driver = null;

    public actionClass(WebDriver driver)
    {
        this.driver = driver;
    }


    // This Method Can Validate HTML element is present or not

    public void checkForElementPresent(By test){
        try{
            driver.findElement(test).isDisplayed();
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(test+"..... is not present ...");}
    }

    // This Method Can Type on a Text Box

    public void TypeOnATextBox(By element , String whatToType){
        try{
            driver.findElement(element).sendKeys(whatToType);
            Thread.sleep(5000);
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(element+"..... is not present ...");}
    }

    // This Method Can CLick on A HTML Element

    public void ClickAndWait(By element){
        try{
            driver.findElement(element).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Thread.sleep(5000);
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(element+"..... is not present ...");}
    }

    public void ClickAndExplicitWait(By element){
        try{
            driver.findElement(element).click();
            Thread.sleep(10000);
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(element+"..... is not present ...");}
    }

    // Scroll to a particular Web Element

    public void scrollToElement(By element){
        try{

            WebElement ele = driver.findElement(element);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" , ele);
            Thread.sleep(5000);
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(element+"..... is not present to Scroll ...");}
    }

    // This reusable method can do a Mouse Hover ..

    public void MouseHover(By element){
        try{

            WebElement ele = driver.findElement(element);
            Actions action = new Actions(driver);
            action.moveToElement(ele).build().perform();
            Thread.sleep(5000);
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(element+"..... is not present to do mouse Hover ...");}
    }



    // To get the text present


    public String getTheText(By element){

        String text = null;
        try{
            text = driver.findElement(element).getText();
        }
        catch(Exception e){e.printStackTrace();
            System.out.println(element+"..... is not present to do mouse Hover ...");}

        return text;
    }


    // Capture Screenshot ...

    public void takeTheScreenShot(String imageName)throws Exception{
        // Convert Web Driver object to Take Screenshot ..
        TakesScreenshot scrshot = ((TakesScreenshot) driver);
        // Call getScreeenshots method to create Image File ..
        File SrcFile = scrshot.getScreenshotAs((OutputType.FILE));
        // Move Image File to a new Destination ...
        File DesSrcFile = new File(System.getProperty("user.dir")+"/screenshot/"+imageName+".png");
        FileUtils.copyFile(SrcFile , DesSrcFile);

    }










}
