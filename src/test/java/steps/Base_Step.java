package steps;

import driver.DriverBrowser;
import org.junit.BeforeClass;

public class Base_Step {

    String navegador = "chrome";       //edge / chrome
    DriverBrowser dr;
    
    public void closeDriver(){
        dr.getDriver().close();
        dr.getDriver().quit();
    }
}
