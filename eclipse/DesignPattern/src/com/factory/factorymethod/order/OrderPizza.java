package com.factory.factorymethod.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.factory.factorymethod.pizza.Pizza;

public abstract class OrderPizza {
	
	abstract Pizza createPizza(String orderType);
	
	// 构造器
	public OrderPizza() {
		Pizza pizza = null;
		String orderType;
		do {
			orderType = getType();
			pizza = createPizza(orderType);			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		} while (true);
	}
	
	// 写一个方法，可以获取客户希望订购的披萨种类
	private String getType() {
		try {
			BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入pizza种类：");
			String type = string.readLine();
			return type;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
