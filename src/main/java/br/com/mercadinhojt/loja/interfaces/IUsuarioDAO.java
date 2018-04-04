package br.com.mercadinhojt.loja.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.mercadinhojt.mercado.models.Usuario;

public interface IUsuarioDAO extends UserDetailsService{
	public void createUser (Usuario usuario) throws SQLException;
	public void delete (Usuario usuario);
	public Usuario loadUserByUsername (String usuario) throws UsernameNotFoundException;
	public List<Usuario> listaUser();	
}
