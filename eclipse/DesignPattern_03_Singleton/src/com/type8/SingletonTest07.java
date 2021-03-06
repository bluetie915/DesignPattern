package com.type8;

//枚举（线程安全，效率高，没有问题，推荐使用）
public class SingletonTest07 {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.INSTANCE;
		Singleton instance2 = Singleton.INSTANCE;
		System.out.println(instance1 == instance2);
		System.out.println("instance1: " + instance1.hashCode());
		System.out.println("instance2: " + instance2.hashCode());
		instance1.sayOK();
	}
}

enum Singleton {
	INSTANCE;
	public void sayOK(){
		System.out.println("ok~~");
	}
}