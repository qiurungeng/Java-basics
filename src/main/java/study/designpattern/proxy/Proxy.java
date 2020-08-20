package study.designpattern.proxy;

public class Proxy implements Rent {
    HouseOwner owner;
    public Proxy(){}
    public Proxy(HouseOwner owner){
        this.owner=owner;
    }

    @Override
    public void rent() {
        seeHouse();
        heTong();
        owner.rent();
        fare();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void heTong(){
        System.out.println("签合同");
    }
    public void fare(){
        System.out.println("收中介费");
    }
}
