package automatizados.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizados.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest{
	
	private static ProdutoPO produtoPage;
	
	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}
	
	@Test
	public void TC001_naoDeveCadastrarProdutoComCamposVazios() {
		
		produtoPage.executarAcaoDeAbrirModalDeCriacao();
		produtoPage.executarAcaoDeAbrirModalDeCriacao();
		
		produtoPage.executarAcaoDeSalvar("", "", "", "", "");
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC002_DeveCadastrarProdutoComCamposPreenchidos() {
		
		produtoPage.executarAcaoDeAbrirModalDeCriacao();
		produtoPage.executarAcaoDeAbrirModalDeCriacao();
		
		produtoPage.executarAcaoDeSalvar("teste", "teste", "teste", "teste", "13/06/2024");
		
		assertTrue(produtoPage.verificarCriacaoDeProduto("teste", "teste", "teste", "teste", "2024-06-13"));
	}
	
	@Test
	public void TC003_DeveCadastrarProdutoComCamposPreenchidos() {
		
		produtoPage.executarAcaoDeAbrirModalDeCriacao();
		produtoPage.executarAcaoDeAbrirModalDeCriacao();

        produtoPage.fecharModal();

        String modalStyle = produtoPage.modalSalvar.getAttribute("style");
        assertTrue(modalStyle.contains("display: none;"));
	}

}
