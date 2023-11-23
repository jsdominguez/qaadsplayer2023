package steps;

import driver.DriverBrowser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Interna_Ads_Player;
import Utils.Utils;

public class Interna_Ads_Player_Step extends Base_Step {

    Interna_Ads_Player internaAdsPlayer;

    String adsStatus = "";
    boolean notFound = false;
    String producto = "";

    String urlPagina = "";
    @Test
    public void Inicio(){
        dr = new DriverBrowser(navegador);
        internaAdsPlayer = new Interna_Ads_Player(dr.getDriver());
    }

    @Test
    @Parameters({"pagina","nota"})
    public void ingresoALaPaginaDeEnLaNotaDe(String pagina, String nota) {
        adsStatus = pagina+"\n";
        producto = pagina;
        urlPagina = nota;
        dr.getDriver().manage().window().maximize();
        dr.getDriver().get(nota);
    }

    @Test
    public void terminaDeCargaLaPaginaPorCompleto() {
        boolean isloadComplete = internaAdsPlayer.ispageComplete();
    }

    @Test
    public void validoLaPublicidadEnNotaInternaDeVideo() {
        try{
            if(!internaAdsPlayer.searchIframePlayerVideo(producto)){
                adsStatus += "AdsPlayer : ";
                adsStatus += "Not Found";
                adsStatus += "\n";
                adsStatus += urlPagina;
                notFound = true;
            }
        }catch(Exception e){
            adsStatus += "AdsPlayer : ";
            adsStatus += "Not Found";
            adsStatus += "\n";
            adsStatus += urlPagina;
            notFound = true;
        }
    }

    @Test
    public void cierroLaPagina() {
        if(notFound){
            new Utils().sendStatusAdsSlack(adsStatus);
        }
        closeDriver();
    }
}