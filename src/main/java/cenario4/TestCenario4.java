/*
o	Acessar o site https://advantageonlineshopping.com
o	No menu, clicar na opção “Special Offer”
o	Clicar no botão “See offer”
o	Clicar no botão “Add to cart”
o	Clicar no carrinho de compras
o	Remover produto do carrinho de compras
o	Validar que o carrinho de compras está vazio
*/

package main.java.cenario4;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCenario4 {
	
	String url;
	WebDriver driver;

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
	
	@Test
	public void removerProdutoDoCarrinho() {
		driver.get(url);
		
		String url2 = "https://advantageonlineshopping.com/#/product/3";
		
		driver.get(url2);
		
		//Clicando no botão Add to cart.
		driver.findElement(By.cssSelector("div[class='fixedBtn']")).click();
		
		//Clicando no carrinho de compras.
		driver.findElement(By.id("shoppingCartLink")).click();
		
		//Removendo produto do carrinho.
		driver.findElement(By.cssSelector("a.remove.red.ng-scope")).click();
		
		//Validando que o carrinho de compras está vazio.
		String validarAlteracaoDeCor = "Your shopping cart is empty";
				
		assertEquals(validarAlteracaoDeCor, driver.findElement(By.cssSelector("label.roboto-bold.ng-scope")).getText());

	}

}
