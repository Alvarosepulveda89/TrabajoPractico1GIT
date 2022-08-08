package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.DataDriven;
import utils.PropertiesDriven;


import java.nio.file.Paths;
import java.util.ArrayList;

public class Tests {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private AccountPage accountPage;
    private ShipmentTrackingPage shipmentTrackingPage;
    private String url;
    private ArrayList<String> dataCP;
    private String browser;
    private String propertyDriver;
    private String rutaDriver;

    //Métodos
    @BeforeTest
    public void preparacion() {

        browser = PropertiesDriven.getProperty("browser");
        propertyDriver = PropertiesDriven.getProperty("propertyDriver");
        rutaDriver = Paths.get(System.getProperty("user.dir"), PropertiesDriven.getProperty("rutaDriver")).toString();
    }

    @BeforeMethod
    public void preTests() {
        dataCP = new ArrayList<>();
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser, rutaDriver, propertyDriver);
        loginPage = new LoginPage(homePage.getDriver());
        signupPage = new SignupPage(loginPage.getDriver());
        accountPage = new AccountPage(homePage.getDriver());
        shipmentTrackingPage = new ShipmentTrackingPage(homePage.getDriver());
        url = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(url);
        homePage.maximizarBrowser();
    }

    @Test
    //catchap
    public void CP01_Registro_correo_existente() throws InterruptedException {
        dataCP = DataDriven.getData("CP01_Registro_correo_existente");
        homePage.linkAccount();
        loginPage.esperarXSegundos(2000);
        loginPage.botonRegistrarse();;
        signupPage.esperarXSegundos(2000);
        signupPage.registro(dataCP.get(1), dataCP.get(2),dataCP.get(3), dataCP.get(4),dataCP.get(5), dataCP.get(6),dataCP.get(7));
        signupPage.esperarXSegundos(2000);
        Assert.assertEquals(signupPage.obtenerErrorAuthCorreo(), dataCP.get(8));
    }


    @Test
    public void CP02_login_no_exitoso() {
        dataCP = DataDriven.getData("CP02_login_no_exitoso");
        homePage.linkAccount();
        loginPage.esperarXSegundos(2000);
        loginPage.login(dataCP.get(1), dataCP.get(2));
        loginPage.esperarXSegundos(2000);
        Assert.assertEquals(loginPage.obtenerErrorCorreo(), dataCP.get(3));
        Assert.assertEquals(loginPage.obtenerErrorClave(), dataCP.get(4));
    }

    @Test
    public void CP03_login_exitoso() {
        dataCP = DataDriven.getData("CP03_login_exitoso");
        homePage.linkAccount();
        loginPage.esperarXSegundos(2000);
        loginPage.login(dataCP.get(1), dataCP.get(2));
        loginPage.esperarXSegundos(2000);
        Assert.assertEquals(homePage.obtenerLabelNombreUsu(), dataCP.get(3));
    }
    @Test
    public void CP04_Convenio_Banmedica() {
        dataCP = DataDriven.getData("CP04_Convenio_Banmedica");
        homePage.linkBeneficiarios();
        homePage.locatorLinkBanmedica();

        Assert.assertEquals(homePage.obtenerUrlPagina(), dataCP.get(1));
    }

    @Test
    public void CP05_buscar_producto() {
        dataCP = DataDriven.getData("CP05_buscar_producto");
        homePage.buscarProducto(dataCP.get(1));
        homePage.esperarXSegundos(2000);
        Assert.assertEquals(homePage.obtenerTituloBusqueda(), dataCP.get(2));
        Assert.assertEquals(homePage.obtenerUrlPagina(), dataCP.get(3));
    }

    @Test
    public void CP06_agregar_direccion_invalida() {
        dataCP = DataDriven.getData("CP06_agregar_direccion_invalida");
        homePage.linkAccount();
        loginPage.esperarXSegundos(2000);
        loginPage.login(dataCP.get(1), dataCP.get(2));
        loginPage.esperarXSegundos(2000);
        homePage.linkAccountUsuario();
        homePage.linkMiCuenta();
        accountPage.LinkMisDirecciones();
        accountPage.LinkAgregarDireccion();
        accountPage.agregarDireccion(dataCP.get(3),dataCP.get(4),dataCP.get(5),dataCP.get(6));
        accountPage.esperarXSegundos(2000);
        accountPage.btnGuardar();
        accountPage.esperarXSegundos(2000);
        Assert.assertEquals(accountPage.obtenerErrorDireccion(), dataCP.get(7));
    }

    @Test
    public void CP07_Cambiar_Comuna() {
        dataCP = DataDriven.getData("CP07_Cambiar_Comuna");
        homePage.cambiarUbicacion(dataCP.get(1));
        homePage.esperarXSegundos(2000);
        Assert.assertEquals(homePage.obtenertextoCambioComuna(), dataCP.get(2));
    }

    @Test
    public void CP08_Buscar_pedido() {
        dataCP = DataDriven.getData("CP08_Buscar_pedido");
        homePage.btnMantenerUbicacion();
        homePage.linkAccount();
        loginPage.esperarXSegundos(2000);
        loginPage.login(dataCP.get(1), dataCP.get(2));
        homePage.sigueTuCompra();
        shipmentTrackingPage.buscarPedido(dataCP.get(3));
       // shipmentTrackingPage.esperarXSegundos(2000);
        Assert.assertEquals(shipmentTrackingPage.obtenerErrorCodPedido(), dataCP.get(4));
    }

    @AfterMethod public void postTests(){
        loginPage.cerrarBrowser();
    }
}

