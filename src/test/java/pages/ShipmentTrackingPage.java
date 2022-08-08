package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class ShipmentTrackingPage extends BaseClass {
    public ShipmentTrackingPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorTxtBuscarPedido = By.xpath("//*[@id=\"order_number\"]");
    By locatorBtnBuscarPedido = By.xpath("//*[@id=\"order-tracking\"]/div[1]/form/div[2]/input");
    By locatorLabelErrCodPedido = By.xpath("//*[@id=\"order-tracking\"]/div[2]/div[3]");

    //Definir las acciones de la Página
    public void buscarPedido(String pedido){
        agregarTexto(esperaExplicita(locatorTxtBuscarPedido),pedido);
        submit(esperaExplicita(locatorBtnBuscarPedido));
    }
    public String obtenerErrorCodPedido() {
        return obtenerTexto(esperaExplicita(locatorLabelErrCodPedido));
    }
}
