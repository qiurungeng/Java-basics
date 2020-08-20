package study.designpattern.factory;

public abstract class PizzaStore {
    Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);	//创建对象的业务
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(String type);	//让子类决定该创建的对象是什么
}
