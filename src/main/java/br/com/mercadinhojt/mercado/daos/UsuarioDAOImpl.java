package br.com.mercadinhojt.mercado.daos;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.mercadinhojt.loja.interfaces.IUsuarioDAO;
import br.com.mercadinhojt.mercado.models.Role;
import br.com.mercadinhojt.mercado.models.Usuario;


public class UsuarioDAOImpl implements IUsuarioDAO, UserDetailsService{
	
	private JdbcTemplate jdbcTemplate;	
	private Connection connection;
	private CallableStatement cs;
	private ResultSet rs;
	
	@Autowired
	public UsuarioDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	
	@Override
	public void createUser(Usuario usuario) throws SQLException {
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			
			BCryptPasswordEncoder encoderPassword = new BCryptPasswordEncoder();
			
			cs = connection.prepareCall("{call dbo.MEJT_SP_CAD_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			cs.setString("MODO", "INSERIR");
			cs.setString("LOGIN", usuario.getLogin());
			cs.setString("NOME", usuario.getNome());
			cs.setString("EMAIL", usuario.getEmail());
			cs.setString("ENDERECO", usuario.getEndereco());			
			cs.setInt("NUMERO", usuario.getNumero());
			cs.setString("CPF", usuario.getCpf());
			cs.setString("RG", usuario.getRg());
			cs.setString("TELEFONE", usuario.getTelefone());
			cs.setDate("DATA_ADMISSAO", new Date(usuario.getDataCadastro().getTimeInMillis()));
			cs.setDate("DATA_NASCIMENTO", new Date(usuario.getDataCadastro().getTimeInMillis()));
			cs.setString("ESTADO_CIVIL", usuario.getEstadoCivil());			
			cs.setString("SEXO", usuario.getSexo());
			System.out.println(encoderPassword.encode(usuario.getSenha()));
			cs.setString("SENHA", encoderPassword.encode(usuario.getSenha()));			
			cs.setBoolean("ATIVO", true);
			cs.setString("ROLE", usuario.getTipoUsuario());	
				
			cs.executeUpdate();				
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			connection.close();
			cs.close();
		}		
	}
	

	@Override
	public Usuario loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Usuario userAcess = new Usuario();
		List<Role> listaPermissao = new ArrayList<>();
		try {			
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = this.connection.prepareCall("{call dbo.MEJT_SP_CAD_USUARIO(?,?)}");
			cs.setString("MODO", "ACESSAR");
			cs.setString("LOGIN", usuario);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				Usuario user = new Usuario();
				Role permissao = new Role();
				
				user.setLogin(rs.getString("LOGIN"));
				user.setSenha(rs.getString("PASSWORD"));
				permissao.setNome(rs.getString("PERMISSAO"));
				listaPermissao.add(permissao);
				user.setRoles(listaPermissao);
				
				userAcess = user;				
			}
		} catch (UsernameNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				connection.close();
				cs.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return userAcess;
	}
	
	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub		
	}

	@Override
	public List<Usuario> listaUser() {
		// TODO Auto-generated method stub
		return null;
	}
}