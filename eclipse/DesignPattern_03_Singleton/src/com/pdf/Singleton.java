package com.pdf;

public class Singleton {
	public static void main(String[] args) {
		Emperor emperor1 = Emperor.getInstance();
		emperor1.emperorInfo();
		Emperor emperor2 = Emperor.getInstance();
		emperor2.emperorInfo();
		Emperor.emperorInfo();
	}
}

class Emperor {
	private static Emperor emperor = null;

	private Emperor() {}

	public static Emperor getInstance() {
		if (emperor == null) {
			emperor = new Emperor();
		}
		return emperor;
	}

	public static void emperorInfo(){
		System.out.println("我就是皇帝某某某...."); 
	}				
}
