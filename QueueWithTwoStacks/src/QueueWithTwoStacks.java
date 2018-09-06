import java.util.Stack;

/**
 * Created by jstadiko on 2018-09-06.
 */
public class QueueWithTwoStacks<T> {
    Stack<T> s1 = new Stack<T>();
    Stack<T> s2 = new Stack<T>();

    public void enqueue(T o){
        s1.push(o);
    }

    public T dequeue(){
        while (!s1.isEmpty())
            s2.push(s1.pop());
        return s2.pop();
    }

    public static void main(String[] args){
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        queue.dequeue();
        queue.enqueue("five");
        queue.enqueue("six");
        queue.dequeue();
        queue.enqueue("seven");
    }
}
