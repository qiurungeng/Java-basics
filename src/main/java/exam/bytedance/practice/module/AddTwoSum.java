package exam.bytedance.practice.module;

public class AddTwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i1 = listToInt(l1);
        int i2 = listToInt(l2);
        return intToList(i1 + i2);
    }

    private int listToInt(ListNode node){
        int res = 0;
        int multi = 1;
        while(node != null){
            res += multi * res;
            multi *= 10;
            node = node.next;
        }
        return res;
    }

    private ListNode intToList(int v){
        String s = v + "";
        char[] chars = s.toCharArray();
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        for(int i = chars.length - 1 ; i >= 0 ; i--){
            pointer.next = new ListNode(chars[i] - '0');
            pointer = pointer.next;
        }
        return res.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println(Long.parseLong("9999999991"));
    }
}
