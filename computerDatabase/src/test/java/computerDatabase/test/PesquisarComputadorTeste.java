package computerDatabase.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import computerDatabase.page.PesquisarComputador;
import computerDatabase.util.DriverFactory;
import computerDatabase.util.ScreenShot;

public class PesquisarComputadorTeste {
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		driver = new DriverFactory().chromeDriverFactory();
	}

	@Test
	public void pesquisarComputadorSucesso() throws Exception{
		
		String texto = "Acer";
		
		PesquisarComputador pesquisarComputador = new PesquisarComputador(driver);
		pesquisarComputador.preencherCampoPesquisa(texto);
		pesquisarComputador.clicarPesquisar();
		
		List<String> resultados = pesquisarComputador.pegarResultadoPesquisa();
		for(String resultado : resultados) {
			Assert.assertTrue(resultado.contains(texto));
		}
		
		ScreenShot screenShot = new ScreenShot(driver);
		screenShot.takeScreenShot();

	}
	
	@Test
	public void PesquisaSemRegistrosRecuperados() throws Exception {
		String texto = "testetestetestetesteaskfhlaskfhlsa";
		
		PesquisarComputador pesquisarComputador = new PesquisarComputador(driver);
		pesquisarComputador.preencherCampoPesquisa(texto);
		pesquisarComputador.clicarPesquisar();
		
		Assert.assertEquals("Nothing to display", pesquisarComputador.mensagemPesquisaSemRegistros());
		
		ScreenShot screenShot = new ScreenShot(driver);
		screenShot.takeScreenShot();
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
