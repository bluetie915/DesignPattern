package com.factory.simplefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.factory.simplefactory.pizza.Pizza;

//简单工厂模式
public class OrderPizza2 {
	
	//定义一个简单工厂对象
	SimpleFactory simpleFactory;
	Pizza pizza = null;
	
	//构造器
	public OrderPizza2(SimpleFactory simpleFactory){
		setFactory(simpleFactory);
	}
	
	public void setFactory(SimpleFactory simpleFactory){
		String orderType = "";
		this.simpleFactory = simpleFactory;
		do {
			orderType = getType();
			pizza = this.simpleFactory.createPizza(orderType);
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
