package br.com.mercadinhojt.mercado.controllers;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mercadinhojt.loja.interfaces.IPreencheListaComboDAO;
import br.com.mercadinhojt.loja.interfaces.IProdutoDAO;
import br.com.mercadinhojt.loja.validation.ProdutoValidation;
import br.com.mercadinhojt.mercado.infra.FileSaver;
import br.com.mercadinhojt.mercado.models.Categoria;
import br.com.mercadinhojt.mercado.models.Fornecedor;
import br.com.mercadinhojt.mercado.models.Marca;
import br.com.mercadinhojt.mercado.models.Produto;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {	

	private XStream xmlProduto;
	private Writer writer;
	private ByteArrayOutputStream out;	
	
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private IProdutoDAO produtoDAO;
	@Autowired
	private IPreencheListaComboDAO comboDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProdutoValidation());
	}
		
	@RequestMapping("form")
	@Cacheable(value="cadastroProdutos")
	public ModelAndView executa(Produto produto) throws SQLException{	
		
		List<Categoria> categorias = comboDAO.comboCategoria();
		List<Marca> marcas = comboDAO.comboMarca(); 
		List<Fornecedor> fornecedores = comboDAO.comboFornecedor();
		List<Produto> produtos = produtoDAO.listaProduto();
		
		ModelAndView modelAndView = new ModelAndView("produtos/form");	
		modelAndView.addObject("marcas", marcas);
		modelAndView.addObject("fornecedores", fornecedores);
		modelAndView.addObject("categorias", categorias);
		modelAndView.addObject("produtos", produtos);
			
		return modelAndView;		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView cadastrarProduto(MultipartFile ProdutoPath, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) throws SQLException{
		
		if(result.hasErrors()){
			return executa(produto);
		}	
		
		String path = fileSaver.write("arquivos-produto", ProdutoPath);
		produto.setImagemProdutoPath(path);
		
		produtoDAO.createProduto(produto);
		redirectAttributes.addFlashAttribute("sucesso","Produto Cadastrado Com Sucesso!!");
	    return new ModelAndView("redirect:produtos");
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listaProdutos () throws SQLException, IOException{
		
		List<Produto> produtos = produtoDAO.listaProduto();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");		
		
		gerarXML(produtos);
		
		modelAndView.addObject("produtos", produtos);
			
		return modelAndView;
	}	
	
	
	public String gerarXML(List<Produto> produtos) throws IOException{	
		xmlProduto = new XStream(new DomDriver("UTF-8"));
		try {			
			out = new ByteArrayOutputStream();
			writer = new OutputStreamWriter(out,"UTF-8");
			writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  
			xmlProduto.marshal(produtos, new CompactWriter(writer));
			
            String dadosMsg = new String(out.toByteArray(), "UTF-8");  
			
			return dadosMsg;		
			
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
			 return null;
		}	
	}	
}
