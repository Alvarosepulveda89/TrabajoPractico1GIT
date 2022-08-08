package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorLinkAccount = By.xpath("//*[@id=\"no-user\"]/a");
    By locatorLinkAccountUsuario = By.xpath("//*[@id=\"logged-user\"]");
    By locatorLabelNombreUsu = By.xpath("//*[@id=\"logged-user\"]/a/div/div/strong");
    By locatorLinkBeneficiarios = By.xpath("//*[@id=\"navbar\"]/ul/li[4]/a");
    By locatorLinkBanmedica = By.xpath("//*[@id=\"static-nav\"]/li[5]/a");
    By locatorTxtBuscar = By.xpath("//*[@id=\"algolia-search-bar\"]/div/form/input");
    By locatorBtnBuscar = By.xpath("//*[@id=\"algolia-search-bar\"]/div/form/button");
    By locatorTituloBusqueda = By.xpath("//*[@id=\"search-result\"]/div[2]/div[1]/h1");
    By locatorLinkMiCuenta = By.xpath("//*[@id=\"logged-user\"]/ul/li[1]/a/img");
    By locatorLinkComuna = By.xpath("//*[@id=\"mainHeader\"]/div/div[1]/div/div[1]/div/div[3]/ul/li[3]/div/div/div[1]/img");
    By locatorBtnCambiarUbicacion = By.xpath("//*[@id=\"mainHeader\"]/div/div[1]/div/div[1]/div/div[3]/ul/li[3]/div/div/div[2]/div/div/div/div/div/button[2]");
    By locatorTxtComuna = By.xpath("//*[@id=\"mainHeader\"]/div/div[1]/div/div[1]/div/div[3]/ul/li[3]/div/div/div[2]/div/div/div/div/form/div/input[1]");
    By locatorSelecPrimeraComuna = By.xpath("//*[@id=\"mainHeader\"]/div/div[1]/div/div[1]/div/div[3]/ul/li[3]/div/div/div[2]/div/div/div/div/form/div/ul/li");
    By locatorBtnConfirmarUbicacion = By.xpath("//*[@id=\"mainHeader\"]/div/div[1]/div/div[1]/div/div[3]/ul/li[3]/div/div/div[2]/div/div/div/div/form/button");
    By locatorLabelCambioComuna = By.xpath("//*[@id=\"mainHeader\"]/div/div[1]/div/div[1]/div/div[3]/ul/li[3]/div/div/div[2]/div/div/p");
    By locatorBtnMantenerUbicacion = By.xpath("//*[@id=\"mainHeader\"]/div/div[1]/div/div[1]/div/div[3]/ul/li[3]/div/div/div[2]/div/div/div/div/div/button[1]");
    By locatorLinkSigueTuCompra = By.xpath("//*[@id=\"mainHeader\"]/div/div[2]/div/a[2]/div");


    //Definir las acciones de la Página
    public void linkAccount(){
        click(esperaExplicita(locatorLinkAccount));
    }
    public String obtenerLabelNombreUsu(){
        return obtenerTexto(esperaExplicita(locatorLabelNombreUsu));
    }
    public void linkBeneficiarios(){click(esperaExplicita(locatorLinkBeneficiarios));}
    public void locatorLinkBanmedica(){click(esperaExplicita(locatorLinkBanmedica));}
    public void buscarProducto(String buscar){
        agregarTexto(esperaExplicita(locatorTxtBuscar),buscar);
        click(esperaExplicita(locatorBtnBuscar));
    }
    public String obtenerTituloBusqueda() {
        return obtenerTexto(esperaExplicita(locatorTituloBusqueda));
    }
    public void linkAccountUsuario(){
        click(esperaExplicita(locatorLinkAccountUsuario));
    }
    public void linkMiCuenta(){
        click(esperaExplicita(locatorLinkMiCuenta));
    }

    public void cambiarUbicacion(String comuna){
       // click(esperaExplicita(locatorLinkComuna));
        click(esperaExplicita(locatorBtnCambiarUbicacion));
        agregarTexto(esperaExplicita(locatorTxtComuna),comuna);
        click(esperaExplicita(locatorSelecPrimeraComuna));
        click(esperaExplicita(locatorBtnConfirmarUbicacion));
    }
    public String obtenertextoCambioComuna() {
        return obtenerTexto(esperaExplicita(locatorLabelCambioComuna));
    }

    public void btnMantenerUbicacion(){click(esperaExplicita(locatorBtnMantenerUbicacion));}
    public void sigueTuCompra(){click(esperaExplicita(locatorLinkSigueTuCompra));}




}



