package com.pro.tarefas;

import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorTarefas {

	public GerenciadorTarefas() {
        List<Tarefa> tarefas = List.of(
                new Tarefa("Estudar Java", false),
                new Tarefa("Comprar leite", true),
                new Tarefa("Fazer academia", false)
        );

        // Filtrar tarefas concluídas
        List<Tarefa> concluido = tarefas.stream()
        							.filter(Tarefa::isConcluido)
        							.collect(Collectors.toList());

        concluido.forEach(System.out::println);  // Imprime tarefas concluídas
    }
}