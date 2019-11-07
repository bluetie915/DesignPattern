package com.factory.simplefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.factory.simplefactory.pizza.Pizza;

//静态工厂模式
public class OrderPizza3 {

	Pizza pizza = null;
	String orderType = "";
	public OrderPizza3(){
		do {
			orderType = getType();
			pizza = SimpleFactory.createPizza2(orderType);
			if (pizza != null) {
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			}else {
				System.out.println("订购披萨失败");
				break;
			}
		} while (true);
	}
	
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
