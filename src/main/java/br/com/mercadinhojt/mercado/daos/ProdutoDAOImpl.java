package br.com.mercadinhojt.mercado.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.mercadinhojt.loja.interfaces.IProdutoDAO;
import br.com.mercadinhojt.mercado.models.Categoria;
import br.com.mercadinhojt.mercado.models.Marca;
import br.com.mercadinhojt.mercado.models.Preco;
import br.com.mercadinhojt.mercado.models.Produto;

public class ProdutoDAOImpl implements IProdutoDAO {

	private JdbcTemplate jdbTemplate;
	private Connection connection;
	private CallableStatement cs;
	private ResultSet rs;
	
	public ProdutoDAOImpl(DataSource dataSource) {
		jdbTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void createProduto(Produto produto) throws SQLException {
		try {
			connection = jdbTemplate.getDataSource().getConnection();
			 cs = this.connection.prepareCall("{call dbo.MEJT_SP_CAD_PRODUTOS(?, ?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ?) }");				
 			 
			 cs.setString("MODO", "INSERIR");
			 cs.setString("NOME", produto.getNome());
			 cs.setInt("FORNECEDOR", produto.getFornecedor().getIdFornecedor());
			 cs.setInt("MARCA", produto.getMarca().getIdMarca());
			 cs.setString("CODIGO_BARRAS", produto.getCodigoBarras());			 
			 cs.setInt("ID_TIPO_PRODUTO", produto.getCategoria().getId_Categoria());
			 cs.setString("IMG_PRODUTO", produto.getImagemProdutoPath());
			 cs.setInt("QUANTIDADE", produto.getQuantidade());
			 cs.setDate("DATA_REGISTRO", new Date(produto.getDataRegistro().getTimeInMillis()));
			 cs.setDate("DATA_PEDIDO", new Date(produto.getDataPedido().getTimeInMillis()));			 
			 cs.setDouble("VL_PRODUTO", produto.getPreco().getVlCusto());
			 cs.setInt("NUMERO_NF", produto.getNumeroNF());
			 cs.setDouble("VL_VENDA", produto.getPreco().getVlVenda());	
			 cs.setDate("DATA_VALIDADE", new Date(produto.getDataValidade().getTimeInMillis()));
			 cs.setBoolean("ENTRADA_SAIDA",false);
			 			 
			 cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cs.close();
			connection.close();
		}		
	}

	@Override
	public List<Produto> listaProduto() throws SQLException {
		List<Produto> lista = new ArrayList<Produto>();
		
		try {
			connection = jdbTemplate.getDataSource().getConnection();
			cs = this.connection.prepareCall("{call dbo.MEJT_SP_CAD_PRODUTOS(?) }");
			cs.setString("MODO", "LISTA_PRODUTO");
			rs = cs.executeQuery();
			
			while(rs.next()){
				Produto produto = new Produto();
				Marca marca = new Marca();
				Preco preco = new Preco();
				Categoria categoria = new Categoria();
				Calendar data = Calendar.getInstance();	
				
				marca.setNome(rs.getString("NOME_MARCA"));
				categoria.setNome(rs.getString("NOME_TIPO_PRODUTO"));
				preco.setVlVenda(rs.getDouble("VL_VENDA"));				
				produto.setNome(rs.getString("NOME"));				
				data.setTime(rs.getDate("DATA_VALIDADE"));
				
				produto.setDataValidade(data);
				produto.setPreco(preco);
				produto.setCategoria(categoria);
				produto.setMarca(marca);
				
				lista.add(produto);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao Listar os Produtos: "+ e.getMessage());
			e.printStackTrace();
		}finally{
			this.connection.close();
			this.cs.close();
			this.rs.close();
		}
		return lista;
		
	}

	@Override
	public List<Produto> findProduto(String codigoBarras) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

/*

	public List<Produto> buscaProduto (String codigoBarras) throws SQLException{
		List<Produto> lista = new ArrayList<>();
		try {
			cs = this.con.prepareCall("{call dbo.MEJT_SP_CAD_PRODUTOS(?) }");
			cs.setString("MODO", "BUSCA_PRODUTO");
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				Produto produto = new Produto();
				Marca marca = new Marca();
				Categoria categoria = new  Categoria();
				Preco preco = new Preco();
				
				produto.setNome(rs.getString("NOME"));
				produto.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
				
				marca.setNome(rs.getString("NOME_MARCA"));				
				categoria.setNome(rs.getString("NOME_TIPO_PRODUTO"));				
				preco.setVlVenda(rs.getDouble("VL_VENDA"));
				
				produto.setPreco(preco);
				produto.setCategoria(categoria);
				produto.setMarca(marca);
				
				lista.add(produto);
			}
			
			rs = cs.executeQuery();
		} catch (SQLException e) {
			System.out.println("Erro ao Buscar Produto: "+ e.getMessage());
			e.printStackTrace();
		}finally{
			this.con.close();
			this.cs.close();
			this.rs.close();
		}
		
		return lista;
	}
}
*/