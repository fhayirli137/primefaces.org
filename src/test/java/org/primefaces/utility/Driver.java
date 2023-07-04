package org.primefaces.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //Create a private constructor to remove access tho this object

    private Driver(){}

    /*
    We make the WebDriver private, because we want to close access from outside the class.
    We are making it static, because we will use it in a static method
     */

    private static WebDriver driver; //default value==null
    /*
    Create a reusable utility method which will return the same driver instance once we call it.
    -If an instance does not exist, it will create first, and then it will always return same instance
     */
    public static WebDriver getDriver(){

        if (driver == null){
/*
We will read our browserType from the configuration file.
This way we can control which browser is opened from outside our code
 */
            String browserType = ConfigurationReader.getProperty("browser");
/*
Depending on the browserType returned from the configuration.properties
Switch statement will determine the "case" and open the matching browser
 */
            switch (browserType){
                case "chrome":
                  WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driver;
    }
    /*
    Create a new
     */

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();//this line will terminate the currently existing driver completly.It will not exist going forward
            driver=null;//We assign the value back to null so that my "singleton" can create a newer one if needed
        }
    }


}
