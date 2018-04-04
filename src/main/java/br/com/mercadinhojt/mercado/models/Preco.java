package br.com.mercadinhojt.mercado.models;

public class Preco {
	private int idTipoVenda;
	private String tipoVenda;
	private double vlCusto;
	private double vlVenda;
	private double vlTotal;	
		
	public double getVlCusto() {
		return vlCusto;
	}
	public void setVlCusto(double vlCusto) {
		this.vlCusto = vlCusto;
	}
	public double getVlVenda() {
		return vlVenda;
	}
	public void setVlVenda(double vlVenda) {
		this.vlVenda = vlVenda;
	}
	public double getVlTotal() {
		return vlTotal;
	}
	public void setVlTotal(double vlTotal) {
		this.vlTotal = vlTotal;
	}
	public int getIdTipoVenda() {
		return idTipoVenda;
	}
	public void setIdTipoVenda(int idTipoVenda) {
		this.idTipoVenda = idTipoVenda;
	}
	public String getTipoVenda() {
		return tipoVenda;
	}
	public void setTipoVenda(String tipoVenda) {
		this.tipoVenda = tipoVenda;
	}
	
	@Override
	public String toString() {
		return "Preco [idTipoVenda=" + idTipoVenda + ", tipoVenda=" + tipoVenda
				+ ", vlCusto=" + vlCusto + ", vlVenda=" + vlVenda
				+ ", vlTotal=" + vlTotal + "]";
	}
}
