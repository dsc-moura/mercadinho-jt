package br.com.mercadinhojt.loja.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.mercadinhojt.mercado.models.Categoria;
import br.com.mercadinhojt.mercado.models.Fornecedor;
import br.com.mercadinhojt.mercado.models.Marca;

public interface IPreencheListaComboDAO {
	public List<Marca> comboMarca() throws SQLException;
	public List<Fornecedor> comboFornecedor() throws SQLException;
	public List<Categoria> comboCategoria() throws SQLException;
}
