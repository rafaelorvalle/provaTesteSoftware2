package automatizados.test;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizados.pageObject.LoginPO;

public class LoginTest extends BaseTest {

	private static LoginPO loginPage;

	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}

	@Test
	public void TC001_naoDeveSerPossivelLogarNoSistemaComEmailESenhaVazios() {
		/*
		 * loginPage.inputEmail.sendKeys(""); loginPage.inputSenha.sendKeys("");
		 * 
		 * loginPage.buttonEntrar.click();
		 * 
		 * String mensagem = loginPage.spanMensagem.getText();
		 * 
		 * assertEquals(mensagem,
		 * "Informe usuário e senha, os campos não podem ser brancos.");
		 */

		// assertTrue(mensagem, mensagem.contains("Informe usuário e senha, os campos
		// não podem ser brancos."));
		
		loginPage.executarAcaoDeLogar("", "");
		
		String mensagem =  loginPage.obterMensagem();
		
		assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
	}

}
