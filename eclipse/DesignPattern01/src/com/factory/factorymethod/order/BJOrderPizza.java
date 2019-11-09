package com.factory.factorymethod.order;

import com.factory.factorymethod.pizza.BJCheesePizza;
import com.factory.factorymethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza{

	@Override
	Pizza createPizza(String orderType) {
		Pizza pizza = null;
		if (orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		}
		
		return pizza;
	}

}
