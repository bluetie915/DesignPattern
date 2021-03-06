package com.type1;

//饿汉式（静态变量，浪费空间（没有懒加载），推荐单线程使用）
public class SingletonTest01 {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance1 == instance2);
		System.out.println("instance1: " + instance1.hashCode());
		System.out.println("instance2: " + instance2.hashCode());
	}
}

class Singleton {

	private Singleton() {}

	private final static Singleton instance = new Singleton();

	public static Singleton getInstance() {
		return instance;
	}
}