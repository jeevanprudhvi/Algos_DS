import java.util.Arrays;

/**
 * Created by jstadiko on 2018-09-02.
 */
public class ResizingArrayStackOfStrings {
    private int top = -1;
    private String[] stack;
    public ResizingArrayStackOfStrings() {
        stack = new String[1];
    }
    public void push(String item){
        if(isFull())
            resize();
        stack[++top] = item;
    }
    public String pop(){
        if(top == stack.length/4)
            shrink();
        String temp = stack[top];
        stack[top--] = null;
        return temp;
    }
    private void shrink(){
        String[] temp = new String[stack.length/2];
        for(int i=0;i<temp.length;i++)
            temp[i]=stack[i];
        stack = temp;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    private void resize(){
        String[] temp = new String[stack.length*2];
        for(int i=0;i<stack.length;i++)
            temp[i]=stack[i];
        stack = temp;
    }
    private boolean isFull(){
        return stack.length == top+1;
    }
    public int size(){
        return stack.length;
    }
    public String peekElement(){
        return stack[top];
    }
    public void print(){
        System.out.print(Arrays.toString(stack));
    }

    public static void main(String[] args){
        ResizingArrayStackOfStrings st = new ResizingArrayStackOfStrings();
        st.push("one");
        st.push("two");
        st.push("three");
        st.push("four");
        st.push("five");
        st.push("six");
        st.print();
        System.out.println(st.pop());
        st.print();
        System.out.println(st.size());
        System.out.println(st.peekElement());
        st.print();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.print();
        System.out.println(st.size());
        System.out.println(st.peekElement());
    }
}
