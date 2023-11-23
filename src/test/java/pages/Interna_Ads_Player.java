package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Interna_Ads_Player extends Base_Page {

    public Interna_Ads_Player(WebDriver driver) {
        super(driver);
    }

    public boolean ispageComplete() {
        return isPageLoadComplete();
    }

    public String getNombreCompletoPagina(String producto){
        switch (producto){
            case "AE": producto = "America Entretenimiento"; break;
            case "AN": producto = "America Noticias"; break;
            case "AD": producto = "America Deportes"; break;
            case "CN": producto = "America Canal N"; break;
        }
        return producto;
    }
    public boolean searchIframePlayerVideo(String producto) {
        String iframeSelectorVideo = "";
        switch (producto){
            case "AE":
                iframeSelectorVideo = "#LEADERBOARD1  + div div[class='md:flex'] > div > div:first-child iframe";
                break;
            case "AN":
                iframeSelectorVideo = ".Element_videoMS__OL1xp > iframe";
                break;
            case "AD":
                iframeSelectorVideo = "#LEADERBOARD1  + div div[class='md:flex'] > div > div:first-child iframe";
                break;
            case "CN":
                iframeSelectorVideo = ".Navbar_root__oKPSU + div .cn-aspect-video > iframe";
                break;
        }

        if(!validate_Interna_Ads_Player(iframeSelectorVideo)){
            return false;
        };

        return true;
    }

    public boolean validate_Interna_Ads_Player(String iframeSelectorVideo) {
        clickVideoPlay(iframeSelectorVideo);
        //getDriver().findElement(By.cssSelector(iframeSelectorVideo)).click();
        changeIframe(iframeSelectorVideo);
        return changeIframeID(0);
    }

}