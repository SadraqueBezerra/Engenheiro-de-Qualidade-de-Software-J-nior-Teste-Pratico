package main.java.cenario1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCenario1 {
	
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
	public void validarEspecificaçõesProduto() {
		driver.get(url);
		
		String url2 = "https://advantageonlineshopping.com/#/product/3";
		
		driver.get(url2);
		
		
		//Validando especificações do produto
		
		String especificacaoProduto = "HP PAVILION 15Z TOUCH LAPTOP";
				
		assertEquals(especificacaoProduto, driver.findElement(By.cssSelector("h1.roboto-regular.screen768.ng-binding")).getText());

	}

}


