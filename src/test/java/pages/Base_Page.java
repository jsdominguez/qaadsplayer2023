package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_Page {

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    boolean found;
    public Base_Page(WebDriver wdriver){
        driver = wdriver;
        wait = new WebDriverWait(wdriver, 10);
    }
    public void setText(WebElement element, String texto){
        waitElementVisible(element);
        element.clear();
        element.sendKeys(texto);
    }

    public void pressEnter(WebElement element){
        waitElementVisible(element);
        element.sendKeys(Keys.ENTER);
    }

    public void click(WebElement element){
        waitElementVisible(element);
        element.click();
    }

    public void clickVideoPlay(String locator){
        try{
            //waitElementVisible(locator);
            Thread.sleep(10000);
            getDriver().findElement(By.cssSelector(locator)).click();
            Thread.sleep(7000);
        }catch (Exception e){}
    }

    //accion click con JS, se utiliza cuando no funciona realizando click convencional
    public void clickJS(WebElement element){
        waitElementVisible(element);
        js.executeScript("arguments[0].click()",element);
    }
    public void scrollDown(WebElement element){
        try{
            waitElementVisible(element);
            js.executeScript("arguments[0].scrollIntoView(true);",element);
        }catch (Exception e){}
    }

    public void scrollUntilFooter(){
        try{
            js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(20000);
        }catch (Exception e){}
    }

    public String getText(String locator){
        waitElementVisible(locator);
        return getDriver().findElement(By.cssSelector(locator)).getText();
    }

    public String getTextIframe(String locator){
        System.out.println(getDriver().findElement(By.cssSelector(locator)).getSize());
        System.out.println(getDriver().findElement(By.cssSelector(locator)).getText());
        System.out.println(getDriver().findElement(By.cssSelector(locator)).getText().toString());
        System.out.println(getDriver().findElement(By.cssSelector(locator)).getTagName());
        return "Gaa";
    }

    public boolean changeIframe(String locator){
        try{
            getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(locator)));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean changeIframeID(int indice){
        try{
            getDriver().switchTo().frame(indice).findElement(By.cssSelector(".ima-sdk-frame .videoAdUi")).getAttribute("class");
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void returnIframeParent(){
        try{
            getDriver().switchTo().defaultContent();
        }catch (Exception e){}
    }
    public void waitElementVisible(String locator){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public boolean waitElementLocated(String locator, String typeSelector){
        try{
            switch (typeSelector){
                case "css": getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator))); break;
                case "xpath" : getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))); break;
                case "id" : getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));break;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void waitElementVisible(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebDriver getDriver(){
        return driver;
    }

    public boolean isPageLoadComplete(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        boolean status = js.executeScript("return document.readyState").toString().equals("complete");
        return status;
    }
    public WebDriverWait getWait() { return wait; }
}
