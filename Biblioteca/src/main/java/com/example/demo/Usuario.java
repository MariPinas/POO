package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private int id;
	private String nome;
	private List<Livro> livrosRetirados = new ArrayList<Livro>();

	public Usuario(String st, int id) {
		this.nome = st;
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Livro> getLivrosRetirados() {
		return livrosRetirados;
	}

	public void setLivrosRetirados(List<Livro> livrosRetirados) {
		this.livrosRetirados = livrosRetirados;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean retiraLivro(Livro it) {
		if (isAptoARetirar()) {
			if (it.empresta(this, getPrazoMaximo())) {
				livrosRetirados.add(it);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean devolveLivro(Livro it) {
		if (it.retorna(this)) {
			return livrosRetirados.remove(it);
		} else {
			return false;
		}
	}

	public int getCotaMaxima() {
		return 2;
	}

	public int getPrazoMaximo() {
		return 4;
	}

	public boolean isADevolver() {
		return ((livrosRetirados.size() >= getCotaMaxima() || temPrazoVencido()) ? true : false);
	}

	public boolean isAptoARetirar() {
		return (!isADevolver());
	}

	public boolean temPrazoVencido() {
		for (Livro livro : livrosRetirados) {
			if (livro.isEmAtraso()) {
				return true;
			}
		}
		return false;
	}

	public boolean isProfessor() {
		return (false);
	}

	public String getNome() {
		return nome;
	}

	public String toString() {
		return ("Usuario " + nome);
	}

	public void listaCarga() {
		System.out.println(toString() + " Limite: " + getCotaMaxima() + " Carga atual: " + livrosRetirados.size());

		for (Livro livro : livrosRetirados) {
			System.out.println(livro);
		}
	}
	
	


}
