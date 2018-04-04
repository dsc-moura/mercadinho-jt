package br.com.mercadinhojt.loja.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.mercadinhojt.mercado.models.Produto;

public interface IProdutoDAO {
	public void createProduto(Produto produto) throws SQLException;
	public List<Produto> listaProduto() throws SQLException;
	public List<Produto> findProduto(String codigoBarras);	
}
