package exam.tx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Q2 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        HashMap<Integer, People> peoples = new HashMap<>();
        People start = null;

        for (int i = 0; i < m; i++) {
            line = sc.nextLine().split(" ");
            int memCount = Integer.parseInt(line[0]);
            Group group = new Group(i);
            for (int j = 0; j < memCount; j++) {
                int pCode = Integer.parseInt(line[j+1]);
                if (peoples.containsKey(pCode)){
                    group.addPeople(peoples.get(pCode));
                }else {
                    People p = new People(pCode);
                    if (pCode == 0) start = p;
                    group.addPeople(p);
                    peoples.put(pCode, p);
                }
            }
        }

        assert start != null;
        for (Group group : start.groups) {
            group.announceMember();
        }

        System.out.println(count);
    }

    static class Group{
        int code;
        boolean announced = false;
        ArrayList<People> members = new ArrayList<>();
        void addPeople(People p){
            members.add(p);
            if (!p.groups.contains(this))p.groups.add(this);
        }
        Group(int code){
            this.code = code;
        }

        void announceMember(){
            if(announced) return;

            LinkedList<Group> linked = new LinkedList<>();
            for (People member : members) {
                if (!member.announced){
                    for (Group group : member.groups) {
                        if (group != this) linked.add(group);
                    }
                    count++;
                    member.announced = true;
                }
            }
            for (Group group : linked) {
                group.announceMember();
            }

            this.announced = true;
        }
    }
    static class People{
        int code;
        boolean announced = false;
        ArrayList<Group> groups = new ArrayList<>();

        People(int code){
            this.code = code;
        }
    }
}
