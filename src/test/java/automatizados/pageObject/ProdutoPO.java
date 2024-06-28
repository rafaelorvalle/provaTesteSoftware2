package automatizados.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "data")
	public WebElement inputData;
	
	@FindBy(id = "mensagem")
	public WebElement spanMensagem;	
	
	@FindBy(id = "btn-adicionar")
	public WebElement buttonAdicionar;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;
	
	@FindBy(id = "cadastro-produto")
	public WebElement modalSalvar;
	
	@FindBy(css = "table tbody")
	public WebElement tabelaProdutosCriados;
	
	@FindBy(css = "#cadastro-produto button.close")
    public WebElement closeButton;
	
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public void executarAcaoDeAbrirModalDeCriacao() {
		buttonAdicionar.click();
	}
	
	public void executarAcaoDeSalvar(String codigo, String nome, String quantidade, String valor, String data) {
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);
		buttonSalvar.click();
	}
	
	public boolean verificarCriacaoDeProduto(String codigo, String nome, String quantidade, String valor, String data) {
		boolean bool;
		boolean bool2;
		boolean bool3;
		boolean bool4;
		boolean bool5;
		bool = tabelaProdutosCriados.getText().contains(codigo);
		bool2 = tabelaProdutosCriados.getText().contains(nome);
		bool3 = tabelaProdutosCriados.getText().contains(quantidade);
		bool4 = tabelaProdutosCriados.getText().contains(valor);
		bool5 = tabelaProdutosCriados.getText().contains(data);
		if(bool && bool2 && bool3 && bool4 && bool5) {
			return true;
		} else {			
			return false;
		}
    }
	
	public void fecharModal() {
        closeButton.click();
    }

}
