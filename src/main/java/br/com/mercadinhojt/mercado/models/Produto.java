package br.com.mercadinhojt.mercado.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;



public class Produto {
	private int id_produto;
	private String nome;
	private String codigoBarras;
	private Marca marca;
	private Fornecedor fornecedor;
	private Categoria categoria;	
	private int numeroNF;
	private int quantidade;
	private Preco preco;	
	private String imagemProdutoPath;	

	@DateTimeFormat
	private Calendar dataRegistro;
	@DateTimeFormat
	private Calendar dataPedido;
	@DateTimeFormat
	private Calendar dataValidade;
	
	public String getImagemProdutoPath() {
		return imagemProdutoPath;
	}
	public void setImagemProdutoPath(String imagemProdutoPath) {
		this.imagemProdutoPath = imagemProdutoPath;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
	public int getNumeroNF() {
		return numeroNF;
	}
	public void setNumeroNF(int numeroNF) {
		this.numeroNF = numeroNF;
	}	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
		public Preco getPreco() {
		return preco;
	}
	public void setPreco(Preco preco) {
		this.preco = preco;
	}	
	public Calendar getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public Calendar getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Calendar getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	@Override
	public String toString() {
		return "Produto [id_produto=" + id_produto + ", nome=" + nome
				+ ", codigoBarras=" + codigoBarras + ", marca=" + marca
				+ ", fornecedor=" + fornecedor + ", categoria=" + categoria
				+ ", numeroNF=" + numeroNF + ", quantidade=" + quantidade
				+ ", preco=" + preco + ", imagemProdutoPath="
				+ imagemProdutoPath + ", dataRegistro=" + dataRegistro
				+ ", dataPedido=" + dataPedido + ", dataValidade="
				+ dataValidade + "]";
	}	
}
