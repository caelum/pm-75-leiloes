package br.com.caelum.leilao.integracao;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntegracaoTest {

	@Test
	public void deveLocalizarAMensagemDeBoasVindasDoProjeto(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/pm-75-leiloes/");
		WebElement mensagaem = driver.findElement(By.id("mensagem"));
		assertTrue(mensagaem.isDisplayed());
		assertTrue(mensagaem.getText().equals("Aplicação do curso pm-75-leiloes da Caelum!"));
		driver.close();
	}
}
