package br.com.mercadinhojt.mercado.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private String email;
	
	private String endereco;
	private int numero;
	private String cpf;
	private String rg;
	private String telefone;
	private Calendar dataNascimento;
	private String estadoCivil;
	private String sexo;
	
	@DateTimeFormat
	private Calendar dataAdmissao;
	private boolean ativo;
	private String tipoUsuario;
	private List<Role> roles = new ArrayList<>();
	
	public Usuario(String nome, String login, String senha, String email, String tipo){
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;	
		this.tipoUsuario = tipo;
	}
	
	public Usuario(){
		super();
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getTipo() {
		return tipoUsuario;
	}
	public void setTipo(String tipo) {
		this.tipoUsuario = tipo;
	}	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDataCadastro() {
		return dataAdmissao;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataAdmissao = dataCadastro;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome
				+ ", login=" + login + ", senha=" + senha + ", email=" + email
				+ ", endereco=" + endereco + ", numero=" + numero + ", cpf="
				+ cpf + ", rg=" + rg + ", telefone=" + telefone
				+ ", dataNascimento=" + dataNascimento + ", estadoCivil="
				+ estadoCivil + ", sexo=" + sexo + ", dataAdmissao="
				+ dataAdmissao + ", ativo=" + ativo + ", tipoUsuario="
				+ tipoUsuario + ", roles=" + roles + "]";
	}

}
