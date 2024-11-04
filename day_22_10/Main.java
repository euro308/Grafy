package day_22_10;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        a.addNeighbor(b);
        b.addNeighbor(a);

        a.addNeighbor(c);
        c.addNeighbor(a);

        c.addNeighbor(b);
        b.addNeighbor(c);

        c.addNeighbor(d);
        d.addNeighbor(c);

        List<Vertex> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        Graph graph = new Graph(list);

        List<Vertex> dfs = graph.dfsAlgorithm();
        System.out.println("DSF navštívil vrcholy v následujícím pořadí:");
        for (Vertex vertex: dfs) {
            System.out.print(vertex.toString() + " ");
        }
        System.out.println();
    }
}
