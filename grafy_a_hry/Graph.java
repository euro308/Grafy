package grafy_a_hry;

import java.util.*;

public class Graph {
    private final List<Vertex> vertexList;

    public Graph(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }

    public void addVertex(Vertex vertex) {
        vertexList.add(vertex);
    }

    public List<Vertex> dfsAlgorithm() {
        List<Vertex> path = new LinkedList<>();

        Stack<Vertex> queue = new Stack<>();
        Vertex start = vertexList.getFirst();
        queue.add(start);
        start.setVisited(true);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.pop();

            System.out.println("Jsem " + vertex);
            path.add(vertex);

            Map<Vertex, Integer> neighbors = vertex.getNeighbors();
            for (Vertex neighbor : neighbors.keySet()) {
                if (neighbor.wasVisitedCheck()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
                System.out.println(" a mám souseda " + neighbor);
            }
        }

        for (Vertex v : vertexList) {
            v.setVisited(false);
        }

        return path;
    }

    public List<Vertex> bfsAlgorithm() {
        List<Vertex> path = new LinkedList<>();

        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = vertexList.getFirst();
        queue.add(start);
        start.setVisited(true);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();

            System.out.println("Jsem " + vertex);
            path.add(vertex);

            Map<Vertex, Integer> neighbors = vertex.getNeighbors();
            for (Vertex neighbor : neighbors.keySet()) {
                if (neighbor.wasVisitedCheck()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
                System.out.println(" a mám souseda " + neighbor);
            }
        }

        for (Vertex v : vertexList) {
            v.setVisited(false);
        }

        return path;
    }

    void dijkstraPrint(Node<Vertex> v) {
        System.out.println("Finish found, here is its info:");
        System.out.println("Vertex name: " + v.data);
        System.out.println("The path to it took: " + v.priority + " moves.");
        System.out.println();
        System.out.print("The path goes as following: ");
    }

    public List<Vertex> dijkstraAlgorithm(Vertex from, Vertex to) {
        List<Vertex> path = new LinkedList<>();
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        NodeTable nodeTable = new NodeTable();

        if (from.equals(to)) {
            dijkstraPrint(new Node<>(from, 0, null));
            path.add(from);
            return path;
        }

        for (Vertex v : vertexList) {
            if (v.equals(from)) {
                pq.addElement(v, 0, null);
            }
        }

        while (!pq.isEmpty()) {
            Node<Vertex> v = pq.removeLowest();

            if (v.data.equals(to)) {
                nodeTable.addVertex(v.data, v.priority, v.previous);
                dijkstraPrint(v);

                Vertex temp = v.data;
                path.addFirst(temp);
                do {
                    temp = nodeTable.findPreviousVertex(temp);
                    path.addFirst(temp);
                }
                while (nodeTable.findPreviousVertex(temp) != null);
                return path;
            }

            for (Vertex neighbor : v.data.getNeighbors().keySet()) {
                if (!nodeTable.doesMapContainVertex(neighbor) ||
                        (nodeTable.doesMapContainVertex(neighbor) &&
                                (v.data.getWeight(neighbor) + v.priority) < nodeTable.findPathLength(neighbor))) {
                    pq.addElement(neighbor, v.data.getWeight(neighbor) + v.priority, v.data);
                    nodeTable.addVertex(v.data, v.priority, v.previous);
                }
            }
        }
        System.out.println("Couldn't find path, vertex " + to + " is unreachable.");
        return path;
    }
}
