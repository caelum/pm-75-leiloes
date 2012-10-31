package br.com.caelum.leilao.integracao;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.selenesedriver.TakeScreenshot;

public class BoasVindasTest extends IntegrationTest {

	private WebDriver driver;

	@Before
	public void setup() {
		driver = getDriver();
	}
	
	@Test
	public void deveLocalizarAMensagemDeBoasVindasDoProjeto() throws IOException{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		driver.get("http://localhost:7070/pm-75-leiloes/");
		WebElement mensagaem = driver.findElement(By.id("mensagem"));
		assertTrue(mensagaem.isDisplayed());
		assertTrue(mensagaem.getText().equals("Aplicação do curso pm-75-leiloes da Caelum!"));
		FileUtils.copyFile(file, new File("/tmp/test.png"));
	}
	
	@After
	public void after() {
		driver.close();
	}

}
