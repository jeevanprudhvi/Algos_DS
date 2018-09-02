import java.util.Iterator;

/**
 * Created by jstadiko on 2018-09-02.
 */
public class GStack<T> implements Iterable<T> {
    private Node first = null;
    private long size =0;
    private class Node{
        Node next;
        T data;
    }
    @Override
    public GStackIterator iterator(){
        return new GStackIterator();
    }

    private class GStackIterator implements Iterator<T>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node temp = current;
            current = current.next;
            return temp.data;
        }
    }
    public void push(T data){
        Node oldNode = first;
        first = new Node();
        first.data = data;
        ++size;
        first.next = oldNode;
    }

    public T pop(){
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
        forEach(item->System.out.print(item+" "));
        System.out.println();
    }
    public static void main(String[] args){
        GStack<String> st = new GStack<String>();
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
