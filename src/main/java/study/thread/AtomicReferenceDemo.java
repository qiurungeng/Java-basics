package study.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

@Data
@AllArgsConstructor
class User{
    String name;
    int age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User a = new User("a", 5);
        User b=new User("b",8);
        AtomicReference<User> atomicReference=new AtomicReference<>();
        atomicReference.set(a);
        System.out.println(atomicReference.compareAndSet(a,b)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(a,b)+"\t"+atomicReference.get().toString());
    }
}
