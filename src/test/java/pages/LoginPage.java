package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LoginPage extends BaseClass {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    //Centralizar los localizadores
    By locatorTxtCorreo = By.xpath("//*[@id=\"spree_user_email\"]");
    By locatorTxtClave = By.xpath("//*[@id=\"spree_user_password\"]");
    By locatorbtnIngresar = By.xpath("//*[@id=\"password-credentials\"]/div[4]/button");
    By locatorErroCorreo = By.xpath("//*[@id=\"password-credentials\"]/div[1]/div/small");
    By locatorErroClave = By.xpath("//*[@id=\"password-credentials\"]/div[2]/div/small");
    By locatorLinkRegistrate = By.xpath("//*[@id=\"password-credentials\"]/div[5]/span/span/a");




    //Definir las acciones de la Página
    public void login(String correo, String clave){
        agregarTexto(esperaExplicita(locatorTxtCorreo),correo);
        agregarTexto(esperaExplicita(locatorTxtClave),clave);
        click(esperaExplicita(locatorbtnIngresar));
    }

    public String obtenerErrorCorreo() {
        return obtenerTexto(esperaExplicita(locatorErroCorreo));
    }
    public String obtenerErrorClave() {
        return obtenerTexto(esperaExplicita(locatorErroClave));
    }
    public void botonRegistrarse(){click(esperaExplicita(locatorLinkRegistrate));}



}

