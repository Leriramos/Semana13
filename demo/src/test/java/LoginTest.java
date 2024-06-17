import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginTest {

    private WebDriver cadastro;

    @BeforeTest
    public void setUp() {
        //Configuração do caminho
        cadastro = new ChromeDriver();
        cadastro.get("https://the-internet.herokuapp.com/login");


    }

    @Test
    public void testeLogin() {
        //preencher campo username
        WebElement loginUsuario = cadastro.findElement(By.id("username"));
        loginUsuario.sendKeys("tomsmith");

        //preencher campo password
        WebElement loginSenha = cadastro.findElement(By.id("password"));
        loginSenha.sendKeys("SuperSecretPassword!");

        //clicar no botão login
        WebElement botaoLogin = cadastro.findElement(By.xpath("/html/body/div[2]/div/div/form/button"));
        botaoLogin.click();

        WebElement successMessage = cadastro.findElement(By.id("flash"));
        assertTrue(successMessage.getText().contains("You logged into a secure area!"));
        

        

        //fechar o navegador
       // cadastro.close();
        
    }


    
}
