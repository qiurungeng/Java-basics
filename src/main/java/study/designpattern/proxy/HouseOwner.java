package study.designpattern.proxy;

public class HouseOwner implements Rent{

    @Override
    public void rent() {
        System.out.println("房东我要出租房子！");
    }
}
