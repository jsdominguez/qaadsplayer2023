package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverBrowser {

    private WebDriver driver;
    private ChromeOptions chromeOptions;
    private FirefoxOptions firefoxOptions;
    private EdgeOptions edgeOptions;
    private String incognito = "--incognito";
    private String disableGpu = "--disable-gpu";
    private String enableAutomation = "enable-automation";

    private String disabledev = "--disable-dev-shm-usage";
    private String sandbox = "--no-sandbox";

    public DriverBrowser(String cadena) {
        switch (cadena) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(this.getOptionsEdgeDrivers());
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
                driver = new ChromeDriver(this.getOptionsChromeDrivers());
                break;
            default:
                break;
        }
    }

    public FirefoxOptions getOptionsFirefoxDrivers(){
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.setLogLevel(FirefoxDriverLogLevel.FATAL);
        firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
        firefoxOptions.setLogLevel(FirefoxDriverLogLevel.DEBUG);
        return firefoxOptions;
    }

    public ChromeOptions getOptionsChromeDrivers(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments(this.incognito);
        chromeOptions.addArguments(this.disableGpu);
        chromeOptions.addArguments(this.enableAutomation);
        chromeOptions.addArguments(this.sandbox);
        chromeOptions.addArguments(this.disabledev);
        chromeOptions.setHeadless(true);
        return chromeOptions;
    }

    public EdgeOptions getOptionsEdgeDrivers(){
        edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("-inprivate",true);
        return edgeOptions;
    }

    public WebDriver getDriver() { return this.driver;}

}
