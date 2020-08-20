package study.designpattern.factory;

import java.util.ArrayList;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings=new ArrayList();

    void prepare(){
        System.out.println("preparing "+name);
    }

    void bake(){
        System.out.println("baking...");
    }
    void cut(){
        System.out.println("cutting...");
    }
    void box(){
        System.out.println("boxing...");
    }

    public String getName() {
        return name;
    }
}
