package computerDatabase.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PesquisarComputador extends Principal{
		
	public PesquisarComputador(WebDriver driver) {
		super(driver);
	}
	
	public void preencherCampoPesquisa(String texto) {
		driver.findElement(By.id("searchbox")).sendKeys(texto);
	}
	
	public void clicarPesquisar() {
		driver.findElement(By.id("searchsubmit")).click();
	}
	
	public List<String> pegarResultadoPesquisa() {
		
		List<WebElement> elementos = driver.findElements(By.tagName("tbody"));
		List<String> resultados = new ArrayList<String>();
		for(WebElement elemento : elementos) {
			resultados.add(elemento.getText());
		}
		
		return resultados;
	}
	
	public String mensagemPesquisaSemRegistros() {
		
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/em")).getText();
		
	}

}
