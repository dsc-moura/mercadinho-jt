package br.com.mercadinhojt.mercado.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import br.com.mercadinhojt.loja.interfaces.IPreencheListaComboDAO;
import br.com.mercadinhojt.mercado.models.Categoria;
import br.com.mercadinhojt.mercado.models.Fornecedor;
import br.com.mercadinhojt.mercado.models.Marca;


public class PreencheListaComboDAOImpl implements IPreencheListaComboDAO{
	private JdbcTemplate jdbcTemplate;
	private Connection connection;
	private ResultSet rs;
	private CallableStatement cs;
	
	public PreencheListaComboDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Marca> comboMarca() throws SQLException {		
		List<Marca> lista = new ArrayList<Marca>();
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = this.connection.prepareCall("{call dbo.MEJT_SP_PREENCHER_COMBO(?)}");
			cs.setString("MODO", "MARCAS");
			rs = cs.executeQuery();
			
			while(rs.next()){
				Marca marcas = new Marca();
				marcas.setIdMarca(rs.getInt("ID_MARCA"));
				marcas.setNome(rs.getString(("NOME_MARCA")));
				
				lista.add(marcas);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			connection.close();
			cs.close();
			rs.close();
		}
		return lista;		
	}

	@Override
	public List<Fornecedor> comboFornecedor() throws SQLException {		
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = this.connection.prepareCall("{call dbo.MEJT_SP_PREENCHER_COMBO(?)}");
			cs.setString("MODO", "FORNECEDOR");
			rs = cs.executeQuery();
			
			while(rs.next()){
				Fornecedor fornecedor = new Fornecedor();
				
				fornecedor.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
				fornecedor.setNome(rs.getString(("NOME")));
				
				lista.add(fornecedor);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao Lista Marcas: "+ e.getMessage());
			e.printStackTrace();
		}finally{
			connection.close();
			cs.close();
			rs.close();
		}
		return lista;		
	}

	@Override
	public List<Categoria> comboCategoria() throws SQLException {		
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = this.connection.prepareCall("{call dbo.MEJT_SP_PREENCHER_COMBO(?)}");
			cs.setString("MODO", "CATEGORIA");
			rs = cs.executeQuery();
			
			while(rs.next()){
				Categoria categoria = new Categoria();
				
				categoria.setId_Categoria(rs.getInt("ID_TIPO_PRODUTO"));
				categoria.setNome(rs.getString(("NOME_TIPO_PRODUTO")));
				
				lista.add(categoria);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao Listar Categorias de Produtos: "+ e.getMessage());
			e.printStackTrace();
		}finally{
			connection.close();
			cs.close();
			rs.close();
		}
		return lista;
	}	
}
