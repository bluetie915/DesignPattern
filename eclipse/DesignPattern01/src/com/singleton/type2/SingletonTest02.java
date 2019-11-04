package com.singleton.type2;

//饿汉式（静态代码块，浪费空间（没有懒加载），推荐单线程使用）
public class SingletonTest02 {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance1 == instance2);
		System.out.println("instance1: " + instance1.hashCode());
		System.out.println("instance2: " + instance2.hashCode());
	}
}

class Singleton {

	private Singleton() {
	}

	private static Singleton instance;

	static {
		instance = new Singleton();
	}

	public static Singleton getInstance() {
		return instance;
	}
}