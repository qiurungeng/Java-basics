package spring.bean;

import org.springframework.beans.factory.annotation.Value;

public class BeanA {
    @Value("豆子A")
    private String name;
    @Value("12")
    private int age;
    @Value("20177474")
    private String id;

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
