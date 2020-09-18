package exam.tx;

import com.sun.xml.internal.bind.v2.schemagen.episode.Klass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = new Node("A", 0);
        Node tail = new Node("9", Integer.MAX_VALUE);
        head.last = null;
        head.next = tail;
        tail.last = head;
        tail.next = null;

        String[] nk = sc.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        for (int i = 0; i < n; i++) {
            String txt = sc.nextLine();
            Node node = new Node(txt, 1);
            head.add(node);
        }

        Node pointer = tail.last;
        Node[] kLarge = new Node[k];
        for (int i = 0; i < k; i++) {
            kLarge[i] = pointer;
            pointer = pointer.last;
        }
        Arrays.sort(kLarge, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.times < o2.times) return -1;
                else if (o1.times > o2.times) return 1;
                if (o1.isLargerThan(o2))return 1;
                else return -1;
            }
        });
        for (Node node : kLarge) {
            System.out.println(node.txt+" "+node.times);
        }


        pointer = head.next;
        for (int i = 0; i < k; i++) {
            System.out.println(pointer.txt+" "+pointer.times);
            pointer = pointer.next;
        }

    }

    static class Node{
        String txt;
        Node last;
        Node next;
        int times = 1;

        Node(String txt, int times){
            this.txt = txt;
            this.times = times;
        }

        void add(Node node){
            if (node.times > this.times){
                this.next.add(node);
            }else if(node.times < this.times && node.times > last.times){
                Node last = this.last;
                last.next = node;
                node.last = last;
                this.last = node;
                node.next = this;
            }else if (node.times == this.times){
                if (node.isLargerThan(this)){
                    this.next.add(node);
                }else{
                    Node last = this.last;
                    this.last = node;
                    node.next = this;
                    last.next = node;
                    node.last = last;
                }
            }
        }

        boolean isLargerThan(Node node){
            char[] s1 = this.txt.toCharArray();
            char[] s2 = node.txt.toCharArray();
            for (int i = 0; i < Math.min(s1.length, s2.length); i++) {
                if (s1[i] > s2[i]) return true;
                else if (s1[i] < s2[i]) return false;
            }
            return s1.length > s2.length;
        }
    }
}
