package computerDatabase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Principal {
	
	protected WebDriver driver;
	
	public Principal(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicarBotaoIncluir() {
		driver.findElement(By.id("add")).click();
	}
	
	public String mensagemInclusaoComputador() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]")).getText();			
	}

}
