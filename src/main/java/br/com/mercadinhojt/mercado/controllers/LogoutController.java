package br.com.mercadinhojt.mercado.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class LogoutController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				
		req.getSession().removeAttribute("usuarioLogado");		
		PrintWriter writer = resp.getWriter();		
		writer.println("<html><body>Deslogado com Sucesso</body></html>");
		
	}
}
