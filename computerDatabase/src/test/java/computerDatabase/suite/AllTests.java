package computerDatabase.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import computerDatabase.test.AlterarComputadorTeste;
import computerDatabase.test.IncluirComputadorTeste;
import computerDatabase.test.PesquisarComputadorTeste;

@RunWith(Suite.class)
@SuiteClasses({
	IncluirComputadorTeste.class, 
	PesquisarComputadorTeste.class,
	AlterarComputadorTeste.class
	})
public class AllTests {

}
