/*
o	Acessar o site https://advantageonlineshopping.com
o	No menu, clicar na opção “Special Offer”
o	Clicar no botão “See offer”
o	Alterar a cor do produto
o	Clicar no botão “Add to cart”
o	Validar que produto foi adicionado ao carrinho com a cor selecionada
*/

package main.java.cenario2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCenario2 {
	
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
	public void validarAlteracoesDoProdutoNoCarrinho() {
		driver.get(url);
		
		String url2 = "https://advantageonlineshopping.com/#/product/3";
		
		driver.get(url2);
		
		driver.findElement(By.cssSelector("span.BLACK.bunny")).click();
		
		driver.findElement(By.cssSelector("div[class='fixedBtn']")).click();
		
		driver.findElement(By.id("shoppingCartLink")).click();
		
		//Validando especificações do produto
		String validarAlteracaoDeCor = "BLACK";
				
		assertEquals(validarAlteracaoDeCor, driver.findElement(By.cssSelector("span.style=\"background-color: rgb(65, 65, 65); border: 0px none white;\"")).getText());
		
	}

}
