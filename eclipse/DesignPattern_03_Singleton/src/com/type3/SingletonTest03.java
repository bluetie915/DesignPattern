package com.type3;

//懒汉式（线程不安全）
public class SingletonTest03 {
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
	
	public static Singleton getInstance(){
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
	
}