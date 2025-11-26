package com.pro;

import com.pro.demo.StreamDemo;

public class App {
	public static void main(String[] args) {
		System.out.println("----- Java Lambda | Main -----");

		System.out.println("----- Java Lambda | Stream Demo -----");
		StreamDemo sd = new StreamDemo();
		sd.transformElements();
		sd.filterElements();
		sd.reduceElements();
	}
}