package study.designpattern.factory;

public class Test {
    public static void main(String[] args) {
        PizzaStore nyStore=new NYPizzaStore();
        PizzaStore laStore=new LAPizzaStore();

        System.out.println("吃一个"+nyStore.orderPizza("cheese").getName());
        System.out.println();
        System.out.println("吃一个"+laStore.orderPizza("cheese").getName());
    }
}
