package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class AccountPage extends BaseClass {
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    //Centralizar los localizadores
    By locatorLinkMisDirecciones = By.xpath("//*[@id=\"content\"]/div[2]/div/div[1]/div/div/div/ul/li[3]/a");
    By locatorLinkAgregarDireccion = By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[2]/div/div/a");
    By locatorTxtNombreDireccion = By.xpath("//*[@id=\"address_name\"]");
    By locatorTxtCalle = By.xpath("//*[@id=\"shipping_search\"]");
    By locatorTxtComentario = By.xpath("//*[@id=\"address_address2\"]");
    By locatorTxtTelefono = By.xpath("//*[@id=\"address_phone\"]");
    By locatorBtnGuardar = By.xpath("//*[@id=\"checkout_form_address\"]/div/div[2]/div/div/div/input");
    By locatorlabelErrDireccion = By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div/p");



    //*[@id="checkout_form_address"]/div/div[1]/div/div[3]


    //Definir las acciones de la Página
    public void LinkMisDirecciones(){click(esperaExplicita(locatorLinkMisDirecciones));}
    public void LinkAgregarDireccion(){click(esperaExplicita(locatorLinkAgregarDireccion));}

    public void agregarDireccion(String nombre, String direccion, String comentario, String telefono){
        agregarTexto(esperaExplicita(locatorTxtNombreDireccion),nombre);
        agregarTexto(esperaExplicita(locatorTxtCalle),direccion);
        agregarTexto(esperaExplicita(locatorTxtComentario),comentario);
        agregarTexto(esperaExplicita(locatorTxtTelefono),telefono);
    }
    public void btnGuardar(){submit(esperaExplicita(locatorBtnGuardar));}
    public String obtenerErrorDireccion() {
        return obtenerTexto(esperaExplicita(locatorlabelErrDireccion));
    }

}
