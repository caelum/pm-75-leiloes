package br.com.caelum.leilao.integracao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class IntegrationTest {

	protected WebDriver getDriver() {
		String driver = System.getProperty("browser_driver");
		System.out.println("driver bonito: "+ driver);
		if (driver != null && driver.contains("chromedriver")) {
			System.setProperty("webdriver.chrome.driver", "ChromeDrive/"+ driver);
			return new ChromeDriver();
		}
		return new FirefoxDriver();
	}

}