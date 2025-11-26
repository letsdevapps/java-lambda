package com.pro.demo;

import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
	// Uma das maiores vantagens das lambdas é o uso com Streams. Aqui você pode
	// explorar operações como:

	public StreamDemo() {
	}

	// Map: Transformar elementos de uma coleção.
	public void transformElements() {
		System.out.println("----- Stream Demo | Transform Elements -----");
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		System.out.println("Lista numerica: " + numbers.toString());
		List<Integer> squared = numbers.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println("Função quadrados: " + squared.toString());

//		squared.forEach(s -> System.out.println(s));
	}

	// Filter: Filtrar elementos de uma coleção.
	public void filterElements() {
		System.out.println("----- Stream Demo | Filter Elements -----");
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		System.out.println("Lista numerica: " + numbers.toString());
		List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Função pares: " + evens.toString());
	}

	// Reduce: Reduzir elementos de uma coleção a um único valor.
	public void reduceElements() {
		System.out.println("----- Stream Demo | Reduce Elements -----");
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		System.out.println("Lista numerica: " + numbers.toString());
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println("Função soma: " + sum);
	}
}