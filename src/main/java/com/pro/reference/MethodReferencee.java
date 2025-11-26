package com.pro.reference;

import java.util.List;

public class MethodReferencee {

	public MethodReferencee() {

	}

	public void outPrintln() {
		List<String> lista = List.of("a", "b", "c");
		lista.forEach(System.out::println); // Referência ao método println
	}
}
