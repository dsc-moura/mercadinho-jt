package br.com.mercadinhojt.mercado.models;

public class Marca {
	private String nome;
	private String fabricante;
	private int idMarca;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	@Override
	public String toString() {
		return "Marca [nome=" + nome + ", fabricante=" + fabricante
				+ ", idMarca=" + idMarca + "]";
	}
	
}
