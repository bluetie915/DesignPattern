package com.factory.simplefactory.order;

public class PizzaStore2 {
	public static void main(String[] args) {
		
		//使用简单工厂模式
		new OrderPizza2(new SimpleFactory());
		System.out.println("··退出程序··");
	}
}
