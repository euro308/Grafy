package grafy_a_hry;

public class Node<T> {

    public T data;
    int priority;
    public T previous;

    public Node(T data, int priority, T previous) {
        this.data = data;
        this.priority = priority;
        this.previous = previous;
    }
}
