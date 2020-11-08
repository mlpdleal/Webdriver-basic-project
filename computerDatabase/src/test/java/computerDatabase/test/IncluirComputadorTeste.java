package computerDatabase.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import computerDatabase.page.IncluirComputador;
import computerDatabase.util.DriverFactory;
import computerDatabase.util.ScreenShot;

public class IncluirComputadorTeste {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new DriverFactory().chromeDriverFactory();
	}

	@Test
	public void incluirComputadorComSucesso() throws Exception {
		
		String nome = "Acer Aspire 5";
		IncluirComputador incluirComputador = new IncluirComputador(driver);
		incluirComputador.clicarBotaoIncluir();
		incluirComputador.escreverCampoNome(nome);
		incluirComputador.escreverCampoIntroduced("2018-08-12");
		incluirComputador.escreverCampoDiscontinued("2020-08-12");
		incluirComputador.selecionarCompany("Apple Inc.");
		incluirComputador.clicarBotaoConfirmar();
		
		Assert.assertEquals("Done ! Computer " + nome +  " has been created", 
				incluirComputador.mensagemInclusaoComputador());
		
		ScreenShot screenShot = new ScreenShot(driver);
		screenShot.takeScreenShot();
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
