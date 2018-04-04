package br.com.mercadinhojt.mercado.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mercadinhojt.mercado.daos.ProdutoDAOImpl;
import br.com.mercadinhojt.mercado.models.CarrinhoCompras;
import br.com.mercadinhojt.mercado.models.CarrinhoItem;
import br.com.mercadinhojt.mercado.models.Produto;


@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {
	/*
	private ProdutoDAO dao;
	
	@Autowired
	private CarrinhoCompras carrinho;

	@RequestMapping("/add")
	public ModelAndView add(String codigoBarras) throws SQLException{
		ModelAndView modelAndView = new ModelAndView("redirect:produtos");
		CarrinhoItem carrinhoItem = criarItem(codigoBarras);
		
		carrinho.add(carrinhoItem);
		
		return modelAndView;
	}
	
	private CarrinhoItem criarItem(String codigoBarras) throws SQLException{
		List<Produto> lista = dao.buscaProduto(codigoBarras);
		CarrinhoItem carrinhoItem = new CarrinhoItem(lista);
		return carrinhoItem;
	}
	*/
}
