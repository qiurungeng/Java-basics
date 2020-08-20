package study.designpattern.factory;

//创建者类：洛杉矶披萨店
public class LAPizzaStore extends PizzaStore{
    //子类决定该创建的对象是什么
    Pizza createPizza(String item){
        if(item.equals("cheese")){
            return new LAStyleCheesePizza();
        }else return null;
    }
}