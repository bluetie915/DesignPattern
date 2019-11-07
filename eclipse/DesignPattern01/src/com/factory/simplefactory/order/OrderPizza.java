package com.factory.simplefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.factory.simplefactory.pizza.CheesePizza;
import com.factory.simplefactory.pizza.GreekPizza;
import com.factory.simplefactory.pizza.Pizza;

public class OrderPizza {

	// 构造器
	public OrderPizza() {
		Pizza pizza = null;
		String orderType;
		do {
			orderType = getType();
			if (orderType.equals("greek")) {
				pizza = new GreekPizza();
				pizza.setName("希腊披萨");
			} else if (orderType.equals("cheese")) {
				pizza = new CheesePizza();
				pizza.setName("奶酪披萨");
			} else {
				break;
			}
			pizza.prepare();
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
