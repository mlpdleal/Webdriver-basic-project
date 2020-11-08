package computerDatabase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlterarComputador extends PesquisarComputador{

	public AlterarComputador(WebDriver driver) {
		super(driver);
	}
	
	public void pesquisarComputador(String texto) {
		
		preencherCampoPesquisa(texto);
		clicarPesquisar();
		driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a")).click();
		
	}
	
	public void escreverCampoNome(String texto) {
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(texto);
	}
	
	public void escreverCampoIntroduced(String texto) {
		driver.findElement(By.id("introduced")).clear();
		driver.findElement(By.id("introduced")).sendKeys(texto);
	}
	
	public void escreverCampoDiscontinued(String texto) {
		driver.findElement(By.id("discontinued")).clear();
		driver.findElement(By.id("discontinued")).sendKeys(texto);
	}
	
	public void clicarDeletarRegistro() {
		driver.findElement(By.xpath("//*[@id=\"main\"]/form[2]/input")).click();
	}
	
	
	public void clicarSalvarRegistro() {
		driver.findElement(By.xpath("//*[@id=\"main\"]/form[1]/div/input")).click();
	}

}
