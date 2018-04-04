package br.com.mercadinhojt.mercado.conf;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.mercadinhojt.mercado.models.Usuario;


@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String usuario = getUsuario(req);
				
		System.out.println("O usuario "+usuario+" acessou a URI: "+ req.getRequestURI());			
				
		chain.doFilter(req, response);
	}

	private String getUsuario(HttpServletRequest req) {	
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");		
		if(usuario == null) return "<deslogado>";		
		return usuario.getLogin();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}
	
}
