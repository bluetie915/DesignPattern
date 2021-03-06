package com.type7;

//静态内部类（线程安全，效率高，没有问题，推荐使用）
public class SingletonTest07 {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance1 == instance2);
		System.out.println("instance1: " + instance1.hashCode());
		System.out.println("instance2: " + instance2.hashCode());
	}
}

class Singleton {

	private static volatile Singleton instance;

	private Singleton() {
	}
	//静态内部类在主类被装载时不会立即实例化
	//当getInstance()方法被调用的时候才会装载，从而完成实例化
	private static class SingletonInstance{
		private static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingletonInstance.INSTANCE;
	}

}