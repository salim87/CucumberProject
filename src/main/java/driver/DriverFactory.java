package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver= new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(webDriver.get()==null){
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }
    private static WebDriver createDriver(){
        WebDriver driver = null;

        String browserType="chrome";

        switch (getBrowserType()){
            case "chrome" ->{
                WebDriverManager.chromedriver().setup();
                driver =new ChromeDriver();
                break;
            }
            case "firefox" ->{
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        return driver;
    }

    public static String getBrowserType(){
        String browserType = null;

        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            prop.load(fis);
            browserType =prop.getProperty("browser").toLowerCase().trim();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return browserType;
    }
    public static void cleanupDriver(){
        webDriver.get().quit();
        webDriver.remove();
    }
}
