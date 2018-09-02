import java.util.Arrays;

/**
 * Created by jstadiko on 2018-09-02.
 */
public class LinkedQueueOfStrings {
    private Node first = null, last = null;
    public LinkedQueueOfStrings() {
    }
    private class Node{
        Node next;
        String item;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void enqueue(String item){
        Node oldNode  = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldNode.next = last;
    }
    public String dequeue(){
        Node temp = first;
        first = first.next;
        if(isEmpty()) last = null;
        return temp.item;
    }
    public void print(){
        Node temp = first;
        while (temp!=null){
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        queue.enqueue("five");
        queue.enqueue("six");
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}
