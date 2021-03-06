package com.type4;

//懒汉式（锁住方法，效率低）
public class SingletonTest04 {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance1 == instance2);
		System.out.println("instance1: " + instance1.hashCode());
		System.out.println("instance2: " + instance2.hashCode());
	}
}

class Singleton{
	
	private static Singleton instance;
	
	private Singleton(){}
	
	public static synchronized Singleton getInstance(){
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
	
}