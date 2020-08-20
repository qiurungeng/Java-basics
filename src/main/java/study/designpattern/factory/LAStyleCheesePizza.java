package study.designpattern.factory;

public class LAStyleCheesePizza extends Pizza{
    LAStyleCheesePizza(){
        name="NEW YORK STYLE CHEESE PIZZA";
        dough="dough";
        sauce="sauce";
        toppings.add("LA Cheese");
    }

    @Override
    void cut() {
        System.out.println("cutting in LA Style...");
    }
}
