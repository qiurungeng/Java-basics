package study.designpattern.factory;

//创建者类：纽约披萨店
public class NYPizzaStore extends PizzaStore{
    //子类决定该创建的对象是什么
    @Override
    Pizza createPizza(String item){
        if(item.equals("cheese")){
            return new NYStyleCheesePizza();
        }else return null;
    }
}