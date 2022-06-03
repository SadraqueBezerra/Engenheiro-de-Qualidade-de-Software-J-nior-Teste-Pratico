/*
o	Acessar o site https://advantageonlineshopping.com
o	Pesquisar o produto clicando no ícone de lupa (Seguir o nome do produto do banco de automação)
o	Selecionar produto pesquisado
o	Alterar a cor do produto
o	Alterar a quantidade de produtos que deseja comprar
o	Clicar no botão “Add to cart”
o	Acessar a página de checkout
o	Validar que a soma dos preços corresponde ao total apresentado na página de checkout
*/

package main.java.cenario3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCenario3 {
	
	String url;
	WebDriver driver;

	@Test
	public void validarEspecificaçõesProduto() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\scorr\\OneDrive\\Documentos\\Caminho\\chromedriver.exe");
		
	}	
	
	@Before
	public void iniciar() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\scorr\\OneDrive\\Documentos\\Caminho\\chromedriver.exe");
		
		url = "https://advantageonlineshopping.com";
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		
	}
		
	@After
	public void finalizar() {
		//driver.quit();
	}
	
	public void validarPaginaCheckout() {
	
	driver.findElement(By.id("menuSearch")).click();
	driver.findElement(By.id("autoComplete")).clear();
	driver.findElement(By.id("autoComplete")).sendKeys("HP Pavilion 15z Touch Laptop ");
	driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);
	
	driver.findElement(By.xpath("//a[@href='#/search/?viewAll=HP Pavilion 15z Touch Laptop']")).click();
	
	driver.findElement(By.id("3")).click();
	
	driver.findElement(By.cssSelector("span.BLACK.bunny")).click();
	
	driver.findElement(By.cssSelector("div[class='plus']")).click();
	
	driver.findElement(By.cssSelector("div[class='fixedBtn']")).click();
	
	driver.findElement(By.id("checkOutPopUp")).click();
	
	//Validando a soma dos preços na página de Checkout
	
	String somaPreco = "$899.98";
	
	assertEquals(somaPreco, driver.findElement(By.cssSelector("span.roboto-medium.totalValue.ng-binding")).getText());
	
	
	}
	
}
