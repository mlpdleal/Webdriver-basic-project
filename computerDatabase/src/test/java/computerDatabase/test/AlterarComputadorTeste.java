package computerDatabase.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import computerDatabase.page.AlterarComputador;
import computerDatabase.page.IncluirComputador;
import computerDatabase.util.DriverFactory;
import computerDatabase.util.ScreenShot;

public class AlterarComputadorTeste {

	private WebDriver driver;
	private String nomeComputador = "Acer Aspire 5";
	
	@Before
	public void setUp() throws Exception {
		driver = new DriverFactory().chromeDriverFactory();
		incluirRegistro(nomeComputador);
	}

	@Test
	public void alterarComputadorComSucesso() throws Exception {
		
		String nome = "Acer aspire 6";
		
		AlterarComputador alterarComputador = new AlterarComputador(driver);
		alterarComputador.pesquisarComputador(nomeComputador);
		alterarComputador.escreverCampoNome(nome);
		alterarComputador.escreverCampoIntroduced("2020-06-10");
		alterarComputador.escreverCampoDiscontinued("2022-09-15");
		alterarComputador.clicarSalvarRegistro();
		
		Assert.assertEquals("Done ! Computer " + nome +  " has been updated", 
				alterarComputador.mensagemInclusaoComputador());
		
		ScreenShot screenShot = new ScreenShot(driver);
		screenShot.takeScreenShot();
		
	}
	
	@Test
	public void deletarRegistro() throws Exception {
		AlterarComputador alterarComputador = new AlterarComputador(driver);
		alterarComputador.pesquisarComputador(nomeComputador);
		alterarComputador.clicarDeletarRegistro();
		
		Assert.assertEquals("Done ! Computer " + nomeComputador +  " has been deleted", 
				alterarComputador.mensagemInclusaoComputador());
		
		ScreenShot screenShot = new ScreenShot(driver);
		screenShot.takeScreenShot();
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	private void incluirRegistro(String nomeComputador) {
		IncluirComputador incluirComputador = new IncluirComputador(driver);
		incluirComputador.clicarBotaoIncluir();
		incluirComputador.escreverCampoNome(nomeComputador);
		incluirComputador.escreverCampoIntroduced("2018-08-12");
		incluirComputador.escreverCampoDiscontinued("2020-08-12");
		incluirComputador.selecionarCompany("Apple Inc.");
		incluirComputador.clicarBotaoConfirmar();
	}
	

}
