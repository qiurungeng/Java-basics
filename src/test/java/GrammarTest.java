

import com.google.protobuf.Internal;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.locks.StampedLock;

public class GrammarTest {

    public void testStackAPI(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.peek();
        stack.pop();
    }

    @Test
    public void testListAPI(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        for (Integer integer : array) {
            System.out.println(integer);
        }
        int len = array.length;

        System.out.println("______________________");
        LinkedList<String> strings = new LinkedList<>();
        strings.add("s");
        strings.add("e");
        strings.add(null);
        strings.add("4e");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public void testDeque(){
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.removeFirst();
        deque.removeLast();
        Integer first = deque.peekFirst();


        LinkedList<Integer> list = new LinkedList<>();
        list.remove(new Integer(2));
        Integer first1 = list.removeFirst();
    }

    @Test
    public void testSB(){
        StringBuilder sb = new StringBuilder();
        sb.append("eee,");
        sb.replace(sb.length()-1,sb.length(), "");
        System.out.println(sb.toString());
        int[] a =new int['z'];
        if(a['q']>0){
            System.out.println();
        }
        a['w']=0;
        int[][] b = new int[2][2];
        Arrays.sort(b, Comparator.comparingInt(o -> -o[1]));
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(1,2);
    }

    public void testDoubleList(){
        Deque<Integer> list = new LinkedList<>();

    }

    @Test
    public void testFloor(){
        System.out.println(Math.floor(11/3));
        System.out.println(14 % 6);
    }

    @Test
    public void testAllNull(){
        LinkedList<String> list = new LinkedList<>();
        list.add(null);
        list.add("asd");
        list.add(null);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void testStampedLock(){
        StampedLock stampedLock = new StampedLock();
    }


}
