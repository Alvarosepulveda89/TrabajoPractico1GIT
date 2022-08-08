package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.BaseClass;

public class SignupPage extends BaseClass {
    public SignupPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorTxtCorreo = By.id("spree_user_email");
    By locatorTxtCorreoConf = By.id("spree_user_email_confirmation");
    By locatorTxtClave = By.id("spree_user_password");
    By locatorTxtNombre = By.id("spree_user_first_name");
    By locatorTxtApellidoP = By.id("spree_user_last_name_father");
    By locatorTxtApellidoM = By.id("spree_user_last_name_mother");
    By locatorTxtRut = By.id("spree_user_rut");
    By locatorCboxGenero = By.id("spree_user_gender");
    By locatorCboxDia = By.id("spree_user_birthday_3i");
    By locatorCboxMes = By.id("spree_user_birthday_2i");
    By locatorCboxAnio = By.id("spree_user_birthday_1i");
    By locatorTxtFono = By.id("spree_user_phone_number");
    By locatorChkTermA = By.xpath("//input[@id='sb_terms_conditions']");
    By locatorChkTermB = By.xpath("//input[@id='msb_terms_conditions']");
    By locatorBtnRegistrar = By.id("submit_signup_form");
    By locatorErroAuthCorreo = By.xpath("//*[@id=\"registerMsgModal\"]/div/div/div[2]/div/h2");


    //Definir las acciones de la Página
    public void registro(String correo, String clave, String nombre, String apellidoP, String apellidoM, String rut,String fono) {
        agregarTexto(esperaExplicita(locatorTxtCorreo), correo);
        agregarTexto(esperaExplicita(locatorTxtCorreoConf), correo);
        agregarTexto(esperaExplicita(locatorTxtClave), clave);
        agregarTexto(esperaExplicita(locatorTxtNombre), nombre);
        agregarTexto(esperaExplicita(locatorTxtApellidoP), apellidoP);
        agregarTexto(esperaExplicita(locatorTxtApellidoM), apellidoM);
        agregarTexto(esperaExplicita(locatorTxtRut), rut);
        Select genero = new Select(wait.until(ExpectedConditions.elementToBeClickable(locatorCboxGenero)));
        genero.selectByValue("male");
        Select dia = new Select(wait.until(ExpectedConditions.elementToBeClickable(locatorCboxDia)));
        dia.selectByValue("26");
        Select mes = new Select(wait.until(ExpectedConditions.elementToBeClickable(locatorCboxMes)));
        mes.selectByValue("12");
        Select anio = new Select(wait.until(ExpectedConditions.elementToBeClickable(locatorCboxAnio)));
        anio.selectByValue("1989");
        agregarTexto(esperaExplicita(locatorTxtFono), "956661331");
        click(esperaExplicita(locatorChkTermA));
        click(esperaExplicita(locatorChkTermB));
        click(esperaExplicita(locatorBtnRegistrar));
    }
    public String obtenerErrorAuthCorreo() {
        return obtenerTexto(esperaExplicita(locatorErroAuthCorreo));
    }
}
