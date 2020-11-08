package computerDatabase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class IncluirComputador extends Principal{

	public IncluirComputador(WebDriver driver) {
		super(driver);
	}
	
	public void escreverCampoNome(String texto) {
		driver.findElement(By.id("name")).sendKeys(texto);
	}
	
	public void escreverCampoIntroduced(String texto) {
		driver.findElement(By.id("introduced")).sendKeys(texto);
	}
	
	public void escreverCampoDiscontinued(String texto) {
		driver.findElement(By.id("discontinued")).sendKeys(texto);
	}
	
	public void selecionarCompany(String texto) {
		
		Select select = new Select(driver.findElement(By.id("company")));
		select.selectByVisibleText(texto);
		
	}
	
	public void clicarBotaoConfirmar() {
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input")).click();
	}
	
	

}
