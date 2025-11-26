package com.pro;

import com.pro.demo.StreamDemo;
import com.pro.functional.Operacao;
import com.pro.reference.MethodReferencee;
import com.pro.tarefas.GerenciadorTarefas;

public class App {
	public static void main(String[] args) {
		System.out.println("----- Java Lambda | Main -----");

		System.out.println("----- Java Lambda | Stream Demo -----");
		StreamDemo sd = new StreamDemo();
		sd.transformElements();
		sd.filterElements();
		sd.reduceElements();

		System.out.println("----- Java Lambda | Functional Interface -----");
		Operacao somar = (a, b) -> a + b;
		System.out.println("Operação soma:" + somar.executar(3, 4));
		Operacao subtrair = (a, b) -> a - b;
		System.out.println("Operação soma:" + subtrair.executar(3, 4));

		System.out.println("----- Java Lambda | Referencias a Metodos -----");
		MethodReferencee ref = new MethodReferencee();
		ref.outPrintln();

		System.out.println("----- Java Lambda | Gerenciador de Tarefas -----");
		new GerenciadorTarefas();
	}
}