package br.com.mercadinhojt.mercado.models;

public class Categoria {
	private String nome;
	private int id_Categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId_Categoria() {
		return id_Categoria;
	}

	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", id_Categoria=" + id_Categoria
				+ "]";
	}
}
