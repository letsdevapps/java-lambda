package com.pro.functional;

@FunctionalInterface
public interface Operacao {

//	Interfaces Funcionais: Interfaces que têm um único método abstrato. 
//	As lambdas podem ser usadas para implementar essas interfaces.
	int executar(int a, int b);
}