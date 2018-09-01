import java.util.Arrays;

/**
 * Created by jstadiko on 2018-09-01.
 */
public class LinkedStackOfStrings {
    private Node first = null;
    private long size =0;
    private class Node{
        Node next;
        String data;
    }

    public void push(String data){
        Node temp = new Node();
        temp.data = data;
        ++size;
        if(first == null){
            first = temp;
            return;
        }
        temp.next = first;
        first = temp;
    }

    public String pop(){
        Node temp = first;
        first = first.next;
        --size;
        return temp.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public Long size(){
        return size;
    }

    public void print(){
        Node temp = first;
        while (temp != null){
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        LinkedStackOfStrings st = new LinkedStackOfStrings();
        st.push("one");
        st.push("two");
        st.push("three");
        st.print();
        System.out.println(st.size());
        System.out.println(st.isEmpty());
        st.pop();
        st.pop();
        st.print();
        System.out.println(st.size());
        System.out.println(st.isEmpty());
        st.pop();
        st.print();
        System.out.println(st.size());
        System.out.println(st.isEmpty());
    }
}

