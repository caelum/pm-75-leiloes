package br.com.caelum.leilao.integracao;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntegracaoTest {

	@Test
	public void deveLocalizarAMensagemDeBoasVindasDoProjeto(){
		WebDriver driver = getDriver();
		driver.get("http://localhost:7070/pm-75-leiloes/");
		WebElement mensagaem = driver.findElement(By.id("mensagem"));
		assertTrue(mensagaem.isDisplayed());
		assertTrue(mensagaem.getText().equals("Aplicação do curso pm-75-leiloes da Caelum!"));
		driver.close();
	}

	private WebDriver getDriver() {
		String driver = System.getProperty("browser_driver");
		if (driver.contains("chromedriver")) {
			System.setProperty("webdriver.chrome.driver", "ChromeDrive/" + driver); 
			return new ChromeDriver();
		}
		return new FirefoxDriver();
	}
}
