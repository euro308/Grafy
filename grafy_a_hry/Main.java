package grafy_a_hry;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        a.addNeighbor(b, 5);
        b.addNeighbor(a, 5);

        a.addNeighbor(c, 3);
        c.addNeighbor(a, 3);

        c.addNeighbor(b, 1);
        b.addNeighbor(c, 1);

        c.addNeighbor(d, 7);
        d.addNeighbor(c, 7);

        List<Vertex> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        Graph graph = new Graph(list);

        /*
        List<Vertex> dfs = graph.dfsAlgorithm();
        System.out.println("DFS navštívil vrcholy v následujícím pořadí:");
        for (Vertex vertex : dfs) {
            System.out.print(vertex.toString() + " ");
        }
        System.out.println();

        List<Vertex> bfs = graph.bfsAlgorithm();
        System.out.println("BFS navštívil vrcholy v následujícím pořadí:");
        for (Vertex vertex : bfs) {
            System.out.print(vertex.toString() + " ");
        }
        System.out.println();
        */


        List<Vertex> dijkstra = graph.dijkstraAlgorithm(a, a);
        for (Vertex vertex : dijkstra) {
            System.out.print(vertex.toString() + " ");
        }
        System.out.println();
    }
}
