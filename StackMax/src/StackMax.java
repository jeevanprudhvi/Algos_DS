/**
 * Created by jstadiko on 2018-09-06.
 */
public class StackMax {
    private Node first;
    private Node max;

    public StackMax() {
    }

    public Double getMax(){
        return max.item;
    }
    private class Node{
        Double item;
        Node next;
    }
    public void push(Double item){
        Node x = first;
        first = new Node();
        first.item = item;
        first.next = x;
        if(max == null) {
            max = new Node();
            max.item = item;
        }
        else if(getMax()<item) {
            Node t = new Node();
            t.item = item;
            t.next = max;
            max = t;
        }
    }
    public Double pop(){
        Node temp = first;
        first = first.next;
        Double result = temp.item;
        if(result == max.item)
            max = max.next;
        return result;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public static void main (String[] args){
        StackMax obj = new StackMax();
        obj.push(new Double(33));
        System.out.println("Max at moment ::" + obj.getMax());
        obj.push(new Double(100));
        System.out.println("Max at moment ::" + obj.getMax());
        obj.push(new Double(75));
        System.out.println("Max at moment ::" + obj.getMax());
        obj.push(new Double(80));
        System.out.println("Max at moment ::" + obj.getMax());
        obj.push(new Double(50));
        System.out.println("Max at moment ::" + obj.getMax());
        obj.push(new Double(10));
        System.out.println("Max at moment ::" + obj.getMax());
        obj.push(new Double(125));
        System.out.println("Max at moment ::" + obj.getMax());
        obj.pop();
        System.out.println("Max at moment ::" + obj.getMax());
        obj.pop();
        System.out.println("Max at moment ::" + obj.getMax());
        obj.pop();
        System.out.println("Max at moment ::" + obj.getMax());
        obj.pop();
        System.out.println("Max at moment ::" + obj.getMax());
        obj.pop();
        System.out.println("Max at moment ::" + obj.getMax());
        obj.pop();
        System.out.println("Max at moment ::" + obj.getMax());
        obj.pop();
        if(obj.isEmpty())System.out.println("Stack is empty");

    }
}
