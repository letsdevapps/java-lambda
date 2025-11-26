package com.pro.tarefas;

public class Tarefa {
	private String descricao;
	private boolean concluido;

	public Tarefa(String descricao, boolean concluido) {
		this.descricao = descricao;
		this.concluido = concluido;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	@Override
	public String toString() {
		return descricao + " (Concluída: " + concluido + ")";
	}
}