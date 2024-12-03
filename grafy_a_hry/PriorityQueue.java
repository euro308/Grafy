package grafy_a_hry;

import java.util.LinkedList;

public class PriorityQueue<T> {
    private final LinkedList<Node<T>> list = new LinkedList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    void addElement(T element, int priority, T previous) {
        for(int i = 0; i < list.size(); i++) {
            if(priority < list.get(i).priority) {
                list.add(i, new Node<>(element, priority, previous));
                return;
            }
        }
        list.add(new Node<>(element, priority, previous));
    }

    Node<T> removeLowest() {
        return list.removeFirst();
    }

    Node<T> removeHighest() {
        return list.removeLast();
    }

    void getData() {
        for (Node<T> n : list) {
            System.out.println("Jsem Node " + n.data + " a moje priorita je " +n.priority);
        }
    }
}
