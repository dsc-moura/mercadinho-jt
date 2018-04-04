package br.com.mercadinhojt.mercado.conf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mercadinhojt.loja.interfaces.ITarefas;

@WebServlet(urlPatterns="/gerenciaTarefa")
public class GerenciadorDeTarefas extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
				String tarefa = req.getParameter("tarefa");
		
		if(tarefa == null){
			throw new IllegalArgumentException("Não foi passada nenhuma Tarefa");
		}
		
		tarefa = "br.com.mercadinhojt.mercado.controllers."+tarefa;
		
		try{
			Class<?> tipo = Class.forName(tarefa);
			ITarefas instacia = (ITarefas) tipo.newInstance();
			String pagina = instacia.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req,resp);
			
		}catch(ClassNotFoundException | InstantiationException | IllegalArgumentException 
				| IllegalAccessException | IOException e){			
				throw new ServletException(e);
							
		}
		
	}
}
