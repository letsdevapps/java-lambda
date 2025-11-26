package com.pro;

import com.pro.demo.StreamDemo;
import com.pro.functional.Operacao;

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
	}
}