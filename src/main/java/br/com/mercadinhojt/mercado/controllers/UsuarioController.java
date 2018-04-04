package br.com.mercadinhojt.mercado.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercadinhojt.loja.interfaces.IUsuarioDAO;
import br.com.mercadinhojt.mercado.models.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	
	@RequestMapping("cadastro-usuario")
	@Cacheable(value="cadastroUsuarios")
	public ModelAndView cadastroUser(Usuario usuario) throws SQLException{
		ModelAndView modelAndView = new ModelAndView("usuarios/cadastro-usuario");		
		return modelAndView;		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView cadastrarUsuario(Usuario usuario) throws SQLException{
			
		usuarioDAO.createUser(usuario);
		ModelAndView modelAndView = new ModelAndView("usuarios/cadastro-usuario");
	    return modelAndView;
	}

}
